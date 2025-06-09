package pe.edu.upc.safealert.servicesimplements;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.Rol;
import pe.edu.upc.safealert.entities.Usuario;
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
    public void delete(int idRol) {

        Rol rol = rR.findById(idRol)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        Usuario usuario = rol.getUsuario();
        usuario.getRoles().remove(rol); // actualiza la relación inversa

        rR.delete(rol); // elimina el rol
    }

    @Override
    public void update(Rol r) {rR.save(r);}


}
