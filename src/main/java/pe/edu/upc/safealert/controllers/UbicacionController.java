package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.UbicacionDTO;
import pe.edu.upc.safealert.entities.Ubicacion;
import pe.edu.upc.safealert.servicesinterfaces.IUbicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private IUbicacionService uS;


    //GET TODA LA LISTA
    @GetMapping
    public List<UbicacionDTO> listarUbicaciones(){
        return uS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UbicacionDTO.class);
        }).collect(Collectors.toList());
    }


    //POST
    @PostMapping
    public void insertar(@RequestBody UbicacionDTO UDto){
        ModelMapper modelMapper = new ModelMapper();
        Ubicacion u= modelMapper.map(UDto, Ubicacion.class);
        uS.insert(u);
    }

    //GET POR ID
    @GetMapping("/{idUbicacion}")
    public UbicacionDTO listarId(@PathVariable("idUbicacion") int idUbicacion) {
        ModelMapper m = new ModelMapper();
        UbicacionDTO udto = m.map(uS.listarId(idUbicacion), UbicacionDTO.class);
        return udto;
    }

    //DELETE
    @DeleteMapping("/{idUbicacion}")
    public void eliminar(@PathVariable("idUbicacion") int idUbicacion) {
        uS.delete(idUbicacion);
    }


    //PUT
    @PutMapping
    public void modificar(@RequestBody UbicacionDTO uDTO) {
        ModelMapper m = new ModelMapper();
        Ubicacion u = m.map(uDTO, Ubicacion.class);
        uS.update(u);
    }
}