package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Usuario;

import java.time.LocalDate;

public class NotificacionAlertaDTO {

    private int idNotificacionAlerta;
    private String titulo;
    private String resumen;
    private LocalDate fecha_emision;
    private LocalDate fecha_expiracion;
    private boolean notificacion_revisada;
    private Usuario usuario;

    public int getIdNotificacionAlerta() {
        return idNotificacionAlerta;
    }

    public void setIdNotificacionAlerta(int idNotificacionAlerta) {
        this.idNotificacionAlerta = idNotificacionAlerta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public LocalDate getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(LocalDate fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public boolean getNotificacion_revisada() {
        return notificacion_revisada;
    }

    public void setNotificacion_revisada(boolean notificacion_revisada) {
        this.notificacion_revisada = notificacion_revisada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
