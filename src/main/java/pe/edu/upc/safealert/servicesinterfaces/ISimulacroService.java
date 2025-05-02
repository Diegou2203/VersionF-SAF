package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.Simulacro;

import java.util.List;

public interface ISimulacroService {
    public List<Simulacro> list();
    public void insert(Simulacro s);
    public Simulacro listarId(int idSimulacro);
    public void delete(int idSimulacro);
    public void update(Simulacro s);
}

