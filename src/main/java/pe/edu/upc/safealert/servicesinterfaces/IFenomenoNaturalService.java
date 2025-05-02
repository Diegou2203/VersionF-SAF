package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.FenomenoNatural;

import java.util.List;

public interface IFenomenoNaturalService {

    public List<FenomenoNatural> list();
    public void insert(FenomenoNatural fn);
    public FenomenoNatural listarId(int idFenomenoNatural);
    public void delete(int idFenomenoNatural);
    public void update(FenomenoNatural fn);

    //queries
    public List<String[]> quantityFenomenoPorUbicacion();

    public List<String[]> findHistoricoFenomenosPorIntensidad();
}
