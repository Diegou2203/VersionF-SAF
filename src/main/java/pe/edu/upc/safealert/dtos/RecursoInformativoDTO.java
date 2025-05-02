package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Usuario;

import java.time.LocalDate;

public class RecursoInformativoDTO {

    private int idRecursoInformativo;
    private String tipo;
    private String titulo;
    private String descripcion;
    private String url;
    private LocalDate fecha_publicacion;
    private Usuario usuario;

    public int getIdRecursoInformativo() {

        return idRecursoInformativo;
    }

    public void setIdRecursoInformativo(int idRecursoInformativo) {
        this.idRecursoInformativo = idRecursoInformativo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

