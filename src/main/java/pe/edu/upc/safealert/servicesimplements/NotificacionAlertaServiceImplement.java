package pe.edu.upc.safealert.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.safealert.entities.NotificacionAlerta;
import pe.edu.upc.safealert.repositories.INotificacionAlertaRepository;
import pe.edu.upc.safealert.servicesinterfaces.INotificacionAlertaService;

import java.util.List;

@Service
public class NotificacionAlertaServiceImplement implements INotificacionAlertaService {
    @Autowired
    private INotificacionAlertaRepository naR;

    @Override
    public List<NotificacionAlerta> list() {
        return naR.findAll();
    }

    @Override
    public void insert(NotificacionAlerta na) {
        naR.save(na);
    }

    @Override
    public NotificacionAlerta listarId(int idNotificacionAlerta) {
        return naR.findById(idNotificacionAlerta).orElse(new NotificacionAlerta());
    }

    @Override
    public void delete(int idNotificacionAlerta) {
        naR.deleteById(idNotificacionAlerta);
    }

    @Override
    public void update(NotificacionAlerta na) {
        naR.save(na);
    }

    @Override
    public List<String[]> quantityNotificacionPorUser() {
        return naR.quantityNotificacionesPorUsuario();
    }
}
