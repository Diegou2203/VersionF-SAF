package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.Respuesta;
import pe.edu.upc.safealert.repositories.IRespuestaRepository;
import pe.edu.upc.safealert.servicesinterfaces.IRespuestaService;

import java.util.List;

@Service
public class RespuestaServiceImplement implements IRespuestaService {
    @Autowired
    private IRespuestaRepository reR;

    @Override
    public List<Respuesta> list() {
        return reR.findAll();
    }

    @Override
    public void insert(Respuesta re) {
        reR.save(re);
    }

    @Override
    public Respuesta listarId(int idRespuesta) {
        return reR.findById(idRespuesta).orElse(new Respuesta());
    }

    @Override
    public void delete(int idRespuesta) {
        reR.deleteById(idRespuesta);
    }

    @Override
    public void update(Respuesta re) {
        reR.save(re);
    }

    @Override
    public List<Respuesta> buscarportitulo(String titulo) {return reR.buscartitulo(titulo);}


    @Override
    public List<String[]> cantidadRespuestasPorUsuario() {
        return reR.cantidadRespuestasPorUsuario();
    }

    public List<String[]> cantidadRespuestasPorComentario() {
        return reR.cantidadRespuestasPorComentario();
    }
}
