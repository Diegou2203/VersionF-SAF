package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.ComentarioConsulta;

import java.util.List;

public interface IComentarioConsultaService {
    public List<ComentarioConsulta> list();
    public void insert(ComentarioConsulta co);
    public ComentarioConsulta listarId(int idComentario);
    public void delete(int idComentario);
    public void update(ComentarioConsulta co);
    public List<String[]> contarcomentariousuario();
}
