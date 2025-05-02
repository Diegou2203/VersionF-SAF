package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "ComentarioConsulta")
public class ComentarioConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;

    @Column(name="tema", nullable = false)
    private String tema;

    @Column(name = "contenido", nullable = false, length = 40)
    private String contenido;

    @Column(name = "estado", nullable = false, length = 40)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public ComentarioConsulta() {
    }

    public ComentarioConsulta(int idComentario, LocalDate fechaComentario, String tema, String contenido, String estado, Usuario usuario) {
        this.idComentario = idComentario;
        this.fechaComentario = fechaComentario;
        this.tema = tema;
        this.contenido = contenido;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

