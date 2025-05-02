package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTOListar> listarUsuario(){
        return uS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTOListar.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertarUsuario(@RequestBody UsuarioDTO fNDto){
        ModelMapper modelMapper = new ModelMapper();
        Usuario fn= modelMapper.map(fNDto, Usuario.class);
        uS.insert(fn);
    }


    @GetMapping("/{idUsuario}")
    public UsuarioDTOListar listarId(@PathVariable("idUsuario") int idUsuario) {
        ModelMapper m = new ModelMapper();
        UsuarioDTOListar uDTO = m.map(uS.listarId(idUsuario), UsuarioDTOListar.class);
        return uDTO;
    }


    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {
        uS.delete(idUsuario);
    }


    //PUT
    @PutMapping
    public void modificarUsuario(@RequestBody UsuarioDTO fnDTO) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(fnDTO, Usuario.class);
        uS.update(u);
    }

    @GetMapping("/ListaUsuariosPorZonasAltoRiesgo")
    public List<UsuariosAltoRiesgoDTO> ListarUsuariosEnZonasDeAltoRiesgo() {
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
        return dtos;
    }
}
