package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.Rol;

import java.util.List;

public interface IRolService {

    public List<Rol> list();
    public void insert(Rol r);
    public Rol listarId(int idRol);
    public void delete(int idRol);
    public void update(Rol r);
}
