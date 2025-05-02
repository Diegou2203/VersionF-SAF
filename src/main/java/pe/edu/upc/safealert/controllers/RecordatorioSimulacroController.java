package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.RecordatorioSimulacroDTO;
import pe.edu.upc.safealert.entities.RecordatorioSimulacro;
import pe.edu.upc.safealert.servicesinterfaces.IRecordatorioSimulacroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recordatoriosimulacro")
public class RecordatorioSimulacroController {
    @Autowired
    private IRecordatorioSimulacroService rsS;

    @GetMapping
    public List<RecordatorioSimulacroDTO> listarRecordatorioSimulacro() {
        return rsS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RecordatorioSimulacroDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    public void insertarRecordatorioSimulacro(@RequestBody RecordatorioSimulacroDTO rsDto){
        ModelMapper modelMapper = new ModelMapper();
        RecordatorioSimulacro rs= modelMapper.map(rsDto, RecordatorioSimulacro.class);
        rsS.insert(rs);
    }

    //GET POR ID
    @GetMapping("/{idRecordatorioSimulacro}")
    public RecordatorioSimulacroDTO listarId(@PathVariable("idRecordatorioSimulacro") int idRecordatorioSimulacro) {
        ModelMapper m = new ModelMapper();
        RecordatorioSimulacroDTO rsDTO = m.map(rsS.listarId(idRecordatorioSimulacro), RecordatorioSimulacroDTO.class);
        return rsDTO;
    }

    //DELETE
    @DeleteMapping("/{idRecordatorioSimulacro}")
    public void eliminarRecordatorioSimulacro(@PathVariable("idRecordatorioSimulacro") int idRecordatorioSimulacro) {
        rsS.delete(idRecordatorioSimulacro);
    }


    //PUT
    @PutMapping
    public void modificarRecordatorioSimulacro(@RequestBody RecordatorioSimulacroDTO fnDTO) {
        ModelMapper m = new ModelMapper();
        RecordatorioSimulacro rs = m.map(fnDTO, RecordatorioSimulacro.class);
        rsS.update(rs);
    }



}
