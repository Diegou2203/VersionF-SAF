package pe.edu.upc.safealert.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {
        try {
            uS.delete(idUsuario);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        } catch (IllegalStateException e) {
            log.warn("Error al eliminar usuario: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado al eliminar usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado al eliminar el usuario.");
        }
    }

    @PutMapping("/modify")
    public void modificarUsuario(@RequestBody UsuarioDTO fnDTO) {
        log.info("PUT request: modificar usuario: {}", fnDTO);
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(fnDTO, Usuario.class);
        uS.update(u);
        log.debug("Usuario modificado exitosamente");
    }
}
