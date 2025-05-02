package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.RecursoInformativo;

import java.util.List;

public interface IRecursoInformativoService {
    public List<RecursoInformativo> list();

    public void insert(RecursoInformativo ri);

    public RecursoInformativo listarId(int idRecursoInformativo);

    public void delete(int idRecursoInformativo);

    public void update(RecursoInformativo ri);

    public List<String[]> cantidadRecursosPorUsuario();
}
