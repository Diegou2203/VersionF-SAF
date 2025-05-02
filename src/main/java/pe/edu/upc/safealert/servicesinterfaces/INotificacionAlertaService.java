package pe.edu.upc.safealert.servicesinterfaces;

import pe.edu.upc.safealert.entities.NotificacionAlerta;

import java.util.List;

public interface INotificacionAlertaService {
    public List<NotificacionAlerta> list();

    public void insert(NotificacionAlerta na);

    public NotificacionAlerta listarId(int idNotificacionAlerta);

    public void delete(int idNotificacionAlerta);

    public void update(NotificacionAlerta na);

    public List<String[]> quantityNotificacionPorUser();
}
