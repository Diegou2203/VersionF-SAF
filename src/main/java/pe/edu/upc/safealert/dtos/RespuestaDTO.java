package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Usuario;

import java.time.LocalDate;

public class RespuestaDTO {
    private int idRespuesta;
    private String titulo;
    private String contenido;
    private LocalDate fechacreacion;
    private Usuario usuario;

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


