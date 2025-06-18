package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.Respuesta;

import java.util.List;

public interface IRespuestaService {
    public List<Respuesta> list();

    public void insert(Respuesta re);

    public Respuesta listarId(int idRespuesta);

    public void delete(int idRespuesta);

    public void update(Respuesta re);

    public List<Respuesta> buscarportitulo(String titulo);
    public List<String[]> cantidadRespuestasPorUsuario();

}
