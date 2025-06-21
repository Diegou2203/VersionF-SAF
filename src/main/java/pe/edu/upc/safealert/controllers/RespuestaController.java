package pe.edu.upc.safealert.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.safealert.dtos.ContarRespuestaDTO;
import pe.edu.upc.safealert.dtos.RespuestaDTO;
import pe.edu.upc.safealert.entities.Respuesta;
import pe.edu.upc.safealert.servicesinterfaces.IRespuestaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuesta")
@Slf4j
public class RespuestaController {

    @Autowired
    private IRespuestaService reS;

    @GetMapping("/list")
    public List<RespuestaDTO> listarrespuesta() {
        log.info("Solicitud GET para listar todas las respuestas");
        return reS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/list/BusquedasPorTitulo")
    public List<RespuestaDTO> buscar(@RequestParam String t) {
        log.info("Solicitud GET para buscar respuestas por título: {}", t);
        return reS.buscarportitulo(t).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RespuestaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public void insertar(@RequestBody RespuestaDTO reDto) {
        log.info("Solicitud POST para insertar respuesta: {}", reDto);
        ModelMapper modelMapper = new ModelMapper();
        Respuesta re = modelMapper.map(reDto, Respuesta.class);
        reS.insert(re);
        log.debug("Respuesta insertada correctamente");
    }

    @GetMapping("/list/{idRespuesta}")
    public RespuestaDTO listarId(@PathVariable("idRespuesta") int idRespuesta) {
        log.info("Solicitud GET para obtener respuesta por ID: {}", idRespuesta);
        ModelMapper m = new ModelMapper();
        return m.map(reS.listarId(idRespuesta), RespuestaDTO.class);
    }

    @DeleteMapping("/delete/{idRespuesta}")
    public void eliminar(@PathVariable("idRespuesta") int idRespuesta) {
        log.warn("Solicitud DELETE para eliminar respuesta con ID: {}", idRespuesta);
        reS.delete(idRespuesta);
    }

    @PutMapping("/modify")
    public void modificar(@RequestBody RespuestaDTO reDTO) {
        log.info("Solicitud PUT para modificar respuesta: {}", reDTO);
        ModelMapper m = new ModelMapper();
        Respuesta re = m.map(reDTO, Respuesta.class);
        reS.update(re);
        log.debug("Respuesta modificada correctamente");
    }

    @GetMapping("/list/CantidadRespuestasPorUsuario")
    public List<ContarRespuestaDTO> cantidadRespuestasPorUsuario() {
        log.info("Solicitud GET para contar respuestas por rol de administrador");
        List<ContarRespuestaDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = reS.cantidadRespuestasPorUsuario();
        for (String[] columna : filaLista) {
            ContarRespuestaDTO dto = new ContarRespuestaDTO();
            dto.setUsername(columna[0]);
            dto.setTitulo(columna[1]);
            dto.setContenido(columna[2]);
            dto.setContarrespuesta(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
