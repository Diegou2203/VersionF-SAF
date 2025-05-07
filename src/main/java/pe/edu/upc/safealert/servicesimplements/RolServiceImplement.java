package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.Rol;
import pe.edu.upc.safealert.repositories.IRolRepository;
import pe.edu.upc.safealert.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol r) {rR.save(r);}

    @Override
    public Rol listarId(int idRol) {return rR.findById(idRol).orElse(new Rol());}

    @Override
    public void delete(int idRol) {rR.deleteById(idRol);
    }

    @Override
    public void update(Rol r) {rR.save(r);}


}
