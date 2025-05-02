package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.RolDTO;
import pe.edu.upc.safealert.entities.Rol;
import pe.edu.upc.safealert.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping( "/rol")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listarRol() {
        return rS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertarRol(@RequestBody RolDTO RDto) {
        ModelMapper modelMapper = new ModelMapper();
        Rol r = modelMapper.map(RDto, Rol.class);
        rS.insert(r);
    }

    @GetMapping("{idRol}")
    public RolDTO listarId(@PathVariable ("idRol") int idRol) {
        ModelMapper m = new ModelMapper();
        RolDTO rdto = m.map(rS.listarId(idRol), RolDTO.class);
        return rdto;
    }

    @PutMapping
    public void modificarRol(@RequestBody RolDTO RDto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(RDto, Rol.class);
        rS.update(r);
    }

    @DeleteMapping("/{idRol}")
    public void deleteRol(@PathVariable("idRol") int idRol) {
        rS.delete(idRol);
    }

}
