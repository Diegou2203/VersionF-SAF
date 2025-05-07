package pe.edu.upc.safealert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import pe.edu.upc.safealert.controllers.TipoFenomenoController;
import pe.edu.upc.safealert.dtos.TipoFenomenoDTO;
import pe.edu.upc.safealert.entities.FenomenoNatural;
import pe.edu.upc.safealert.entities.TipoFenomeno;
import pe.edu.upc.safealert.servicesimplements.TipoFenomenoServiceImplement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TipoFenomenoControllerTest {

    @Mock
    private TipoFenomenoServiceImplement tS;

    @InjectMocks
    private TipoFenomenoController tipoFenomenoController;

    private TipoFenomeno tipoFenomeno;
    private TipoFenomenoDTO tipoFenomenoDTO;
    private FenomenoNatural fenomenoNatural;

    @BeforeEach
    void setUp() {
        // Configuración de FenomenoNatural (FK)
        fenomenoNatural = new FenomenoNatural();
        fenomenoNatural.setIdFenomenoNatural(1);
        fenomenoNatural.setNombre_fenomeno("Inundación");

        // Configuración de TipoFenomeno (Entidad)
        tipoFenomeno = new TipoFenomeno();
        tipoFenomeno.setIdTipoFenomeno(1);
        tipoFenomeno.setNombre_tipo("Inundación Costera");
        tipoFenomeno.setDescripcion("Agua que invade zonas costeras");
        tipoFenomeno.setFenomenoNatural(fenomenoNatural);

        // Configuración de TipoFenomenoDTO (DTO)
        tipoFenomenoDTO = new TipoFenomenoDTO();
        tipoFenomenoDTO.setIdTipoFenomeno(1);
        tipoFenomenoDTO.setNombre_tipo("Inundación Costera");
        tipoFenomenoDTO.setDescripcion("Agua que invade zonas costeras");
        tipoFenomenoDTO.setFenomenoNatural(fenomenoNatural);
    }

    @Test
    void testListarTipoFenomeno() {
        when(tS.listar()).thenReturn(Arrays.asList(tipoFenomeno));

        List<TipoFenomenoDTO> result = tipoFenomenoController.listartipofenomeno();

        assertEquals(1, result.size());
        assertEquals(tipoFenomeno.getNombre_tipo(), result.get(0).getNombre_tipo());
        assertEquals(tipoFenomeno.getDescripcion(), result.get(0).getDescripcion());
        assertEquals(tipoFenomeno.getFenomenoNatural(), result.get(0).getFenomenoNatural());
    }

    @Test
    void testInsertarTipoFenomeno() {
        TipoFenomenoDTO dto = new TipoFenomenoDTO();
        dto.setIdTipoFenomeno(2);
        dto.setNombre_tipo("Terremoto");
        dto.setDescripcion("Movimiento de placas tectónicas");
        dto.setFenomenoNatural(fenomenoNatural);

        tipoFenomenoController.insertar(dto);

        verify(tS).insert(any(TipoFenomeno.class));
    }

    @Test
    void testListarIdTipoFenomeno() {
        int id = 1;
        when(tS.listarId(id)).thenReturn(tipoFenomeno);

        TipoFenomenoDTO result = tipoFenomenoController.listarId(id);

        assertNotNull(result);
        assertEquals(tipoFenomeno.getIdTipoFenomeno(), result.getIdTipoFenomeno());
        assertEquals(tipoFenomeno.getNombre_tipo(), result.getNombre_tipo());
        assertEquals(tipoFenomeno.getDescripcion(), result.getDescripcion());
        assertEquals(tipoFenomeno.getFenomenoNatural(), result.getFenomenoNatural());
    }

    @Test
    void testEliminar() {
        int id = 1;
        tipoFenomenoController.eliminar(id);

        verify(tS).delete(id);
    }

    @Test
    void testModificarTipoFenomeno() {
        TipoFenomenoDTO dto = new TipoFenomenoDTO();
        dto.setIdTipoFenomeno(1);
        dto.setNombre_tipo("Inundación Costera Modificado");
        dto.setDescripcion("Descripción modificada");
        dto.setFenomenoNatural(fenomenoNatural);

        tipoFenomenoController.modificar(dto);

        verify(tS).update(any(TipoFenomeno.class));
    }
}