package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.RecordatorioSimulacro;
import pe.edu.upc.safealert.repositories.IRecordatorioSimulacroRepository;
import pe.edu.upc.safealert.servicesinterfaces.IRecordatorioSimulacroService;

import java.util.List;

@Service
public class RecordatorioSimulacroServiceImplement implements IRecordatorioSimulacroService {

    @Autowired
    private IRecordatorioSimulacroRepository rsR;

    @Override
    public List<RecordatorioSimulacro> list() {return rsR.findAll();}

    @Override
    public void insert(RecordatorioSimulacro rs) {rsR.save(rs);}

    @Override
    public RecordatorioSimulacro listarId(int idRecordatorioSimulacro) {return rsR.findById(idRecordatorioSimulacro).orElse(new RecordatorioSimulacro());}

    @Override
    public void delete(int idRecordatorioSimulacro) {rsR.deleteById(idRecordatorioSimulacro);}

    @Override
    public void update(RecordatorioSimulacro rs) {rsR.save(rs);}
}

