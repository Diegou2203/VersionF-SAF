package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "titulo",nullable = false, length = 20)
    private String titulo;
    @Column(name = "contenido",nullable = false, length = 150)
    private String contenido;
    @Column(name = "fechacreacion",nullable = false)
    private LocalDate fechacreacion;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, String titulo, String contenido, LocalDate fechacreacion, Usuario usuario) {
        this.idRespuesta = idRespuesta;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechacreacion = fechacreacion;
        this.usuario = usuario;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
