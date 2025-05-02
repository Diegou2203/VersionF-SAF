package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.SugerenciaPreventivaDTO;
import pe.edu.upc.safealert.entities.SugerenciaPreventiva;
import pe.edu.upc.safealert.servicesinterfaces.ISugerenciaPreventivaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sugerenciapreventiva")
public class SugerenciaPreventivaController {

    @Autowired
    private ISugerenciaPreventivaService spS;

    @GetMapping
    public List<SugerenciaPreventivaDTO> listarSugerenciapreventiva(){
        return spS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, SugerenciaPreventivaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertarSugerenciaPreventiva(@RequestBody SugerenciaPreventivaDTO spDto){
        ModelMapper modelMapper = new ModelMapper();
        SugerenciaPreventiva sp= modelMapper.map(spDto, SugerenciaPreventiva.class);
        spS.insert(sp);
    }

    @GetMapping("/{idSugerenciaPreventiva}")
    public SugerenciaPreventivaDTO listarId(@PathVariable("idSugerenciaPreventiva") int idSugerenciaPreventiva) {
        ModelMapper m = new ModelMapper();
        SugerenciaPreventivaDTO spDTO = m.map(spS.listarId(idSugerenciaPreventiva), SugerenciaPreventivaDTO.class);
        return spDTO;
    }


    @DeleteMapping("/{idSugerenciaPreventiva}")
    public void eliminarSugerenciaPreventiva(@PathVariable("idSugerenciaPreventiva") int idSugerenciaPreventiva) {
        spS.delete(idSugerenciaPreventiva);
    }


    @PutMapping
    public void modificarSugerenciaPreventiva(@RequestBody SugerenciaPreventivaDTO spDTO) {
        ModelMapper m = new ModelMapper();
        SugerenciaPreventiva sp = m.map(spDTO, SugerenciaPreventiva.class);
        spS.update(sp);
    }
}
