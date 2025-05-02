package pe.edu.upc.safealert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.CantidadUbicacionxFDTO;
import pe.edu.upc.safealert.dtos.FenomenoNaturalDTO;
import pe.edu.upc.safealert.dtos.HistoricoFenomenosDTO;
import pe.edu.upc.safealert.entities.FenomenoNatural;
import pe.edu.upc.safealert.servicesinterfaces.IFenomenoNaturalService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fenomeno")
public class FenomenoNaturalController {
    @Autowired
    private IFenomenoNaturalService fnS;
    //GET TODA LA LISTA
    @GetMapping
    public List<FenomenoNaturalDTO> listarUbicaciones(){
        return fnS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, FenomenoNaturalDTO.class);
        }).collect(Collectors.toList());
    }

    //POST
    @PostMapping
    public void insertar(@RequestBody FenomenoNaturalDTO fNDto){
        ModelMapper modelMapper = new ModelMapper();
        FenomenoNatural fn= modelMapper.map(fNDto, FenomenoNatural.class);
        fnS.insert(fn);
    }

    //GET POR ID
    @GetMapping("/{idFenomenoNatural}")
    public FenomenoNaturalDTO listarId(@PathVariable("idFenomenoNatural") int idFenomenoNatural) {
        ModelMapper m = new ModelMapper();
        FenomenoNaturalDTO fnDTO = m.map(fnS.listarId(idFenomenoNatural), FenomenoNaturalDTO.class);
        return fnDTO;
    }

    //DELETE
    @DeleteMapping("/{idFenomenoNatural}")
    public void eliminar(@PathVariable("idFenomenoNatural") int idFenomenoNatural) {
        fnS.delete(idFenomenoNatural);
    }



    //PUT
    @PutMapping
    public void modificar(@RequestBody FenomenoNaturalDTO fnDTO) {
        ModelMapper m = new ModelMapper();
        FenomenoNatural fn = m.map(fnDTO, FenomenoNatural.class);
        fnS.update(fn);
    }

    @GetMapping("/CantidadFenomenosNaturalesPorUbicacion")
    public List<CantidadUbicacionxFDTO> cantidadFenomeno(){
        List<CantidadUbicacionxFDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista=fnS.quantityFenomenoPorUbicacion();
        for(String[] columna:filaLista){
            CantidadUbicacionxFDTO dto = new CantidadUbicacionxFDTO();
            dto.setCiudad(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/HistoricoPorIntensidad")
    public List<HistoricoFenomenosDTO> obtenerHistoricoPorIntensidad() {
        List<String[]> data = fnS.findHistoricoFenomenosPorIntensidad();
        List<HistoricoFenomenosDTO> dtos = new ArrayList<>();

        for (String[] row : data) {
            HistoricoFenomenosDTO dto = new HistoricoFenomenosDTO();
            dto.setIntensidad(row[0]);
            dto.setamio(Integer.parseInt(row[1]));
            dto.setCantidad(Integer.parseInt(row[2]));
            dtos.add(dto);
        }
        return dtos;
    }
}
