package pe.edu.upc.safealert.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.UsuarioDTO;
import pe.edu.upc.safealert.dtos.UsuarioDTOListar;
import pe.edu.upc.safealert.dtos.UsuariosAltoRiesgoDTO;
import pe.edu.upc.safealert.entities.Usuario;
import pe.edu.upc.safealert.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping("/list")
    public List<UsuarioDTOListar> listarUsuario() {
        log.info("GET request: listar todos los usuarios");
        return uS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTOListar.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public void insertarUsuario(@RequestBody UsuarioDTO fNDto) {
        log.info("POST request: insertar nuevo usuario: {}", fNDto);
        ModelMapper modelMapper = new ModelMapper();
        Usuario fn = modelMapper.map(fNDto, Usuario.class);
        uS.insert(fn);
        log.debug("Usuario insertado exitosamente");
    }

    @GetMapping("/list/{idUsuario}")
    public UsuarioDTOListar listarId(@PathVariable("idUsuario") int idUsuario) {
        log.info("GET request: obtener usuario con ID: {}", idUsuario);
        ModelMapper m = new ModelMapper();
        return m.map(uS.listarId(idUsuario), UsuarioDTOListar.class);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {
        log.warn("DELETE request: eliminar usuario con ID: {}", idUsuario);
        uS.delete(idUsuario);
    }

    @PutMapping("/modify")
    public void modificarUsuario(@RequestBody UsuarioDTO fnDTO) {
        log.info("PUT request: modificar usuario: {}", fnDTO);
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(fnDTO, Usuario.class);
        uS.update(u);
        log.debug("Usuario modificado exitosamente");
    }

    @GetMapping("/list/ListaUsuariosPorZonasAltoRiesgo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuariosAltoRiesgoDTO> ListarUsuariosEnZonasDeAltoRiesgo() {
        log.info("GET request: listar usuarios en zonas de alto riesgo");
        List<String[]> data = uS.findUsuariosEnZonasDeAltoRiesgo();
        List<UsuariosAltoRiesgoDTO> dtos = new ArrayList<>();

        for (String[] columna : data) {
            UsuariosAltoRiesgoDTO dto = new UsuariosAltoRiesgoDTO();
            dto.setUsername(columna[0]);
            dto.setTelefono(columna[1]);
            dto.setCorreo(columna[2]);
            dto.setCiudad(columna[3]);
            dtos.add(dto);
        }
        log.debug("Usuarios en zonas de alto riesgo encontrados: {}", dtos.size());
        return dtos;
    }
}
