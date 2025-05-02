package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.TipoFenomeno;

import java.util.List;

public interface ITipoFenomenoService {

    public List<TipoFenomeno> listar();
    public void insert(TipoFenomeno tf);
    public TipoFenomeno listarId(int idTipoFenomeno);
    public void delete(int idTipoFenomeno);
    public void update(TipoFenomeno tf);


}
