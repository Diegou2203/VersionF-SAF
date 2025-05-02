package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.RecordatorioSimulacro;

import java.util.List;

public interface IRecordatorioSimulacroService {

    public List<RecordatorioSimulacro> list();
    public void insert(RecordatorioSimulacro rs);
    public RecordatorioSimulacro listarId(int idRecordatorioSimulacro);
    public void delete(int idRecordatorioSimulacro);
    public void update(RecordatorioSimulacro rs);
}
