package pe.edu.upc.safealert.dtos;

import java.time.LocalDate;

public class BusquedaComentarioPorTemaDTO {
    private String username;
    private String contenido;
    private LocalDate fecha_comentario;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(LocalDate fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }
}