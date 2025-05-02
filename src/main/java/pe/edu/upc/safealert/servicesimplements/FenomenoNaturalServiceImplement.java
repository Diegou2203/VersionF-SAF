package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.FenomenoNatural;
import pe.edu.upc.safealert.repositories.IFenomenoNaturalRepository;
import pe.edu.upc.safealert.servicesinterfaces.IFenomenoNaturalService;

import java.util.List;

@Service
public class FenomenoNaturalServiceImplement implements IFenomenoNaturalService {
    @Autowired
    private IFenomenoNaturalRepository fnR;

    @Override
    public List<FenomenoNatural> list() {return fnR.findAll();}

    @Override
    public void insert(FenomenoNatural fn) {fnR.save(fn);}

    @Override
    public FenomenoNatural listarId(int idFenomenoNatural) {return fnR.findById(idFenomenoNatural).orElse(new FenomenoNatural());}

    @Override
    public void delete(int idFenomenoNatural) {fnR.deleteById(idFenomenoNatural);}

    @Override
    public void update(FenomenoNatural fn) {fnR.save(fn);}

    @Override
    public List<String[]> quantityFenomenoPorUbicacion() {
        return fnR.quantityFenomenoPorUbicacion();
    }

    @Override
    public List<String[]> findHistoricoFenomenosPorIntensidad() {
        return fnR.findHistoricoFenomenosPorIntensidad();
    }
}
