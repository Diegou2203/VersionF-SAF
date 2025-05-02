package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "NotificacionAlerta")
public class NotificacionAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacionAlerta;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "resumen", nullable = false, length = 150)
    private String resumen;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fecha_emision;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fecha_expiracion;

    @Column(name = "notificacion_revisada", nullable = false)
    private boolean notificacion_revisada;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public NotificacionAlerta() {
    }

    public NotificacionAlerta(int idNotificacionAlerta, String titulo, String resumen, LocalDate fecha_emision, LocalDate fecha_expiracion, boolean notificacion_revisada, Usuario usuario) {
        this.idNotificacionAlerta = idNotificacionAlerta;
        this.titulo = titulo;
        this.resumen = resumen;
        this.fecha_emision = fecha_emision;
        this.fecha_expiracion = fecha_expiracion;
        this.notificacion_revisada = notificacion_revisada;
        this.usuario = usuario;
    }

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

