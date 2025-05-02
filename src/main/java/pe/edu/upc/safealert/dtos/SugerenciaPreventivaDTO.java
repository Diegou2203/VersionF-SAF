package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Usuario;

import java.time.LocalDate;

public class SugerenciaPreventivaDTO {

    private int idSugerenciaPreventiva;
    private String area;
    private String descripcion;
    private LocalDate fecha_sugerencia;
    private Usuario usuario;

    public int getIdSugerenciaPreventiva() {
        return idSugerenciaPreventiva;
    }

    public void setIdSugerenciaPreventiva(int idSugerenciaPreventiva) {
        this.idSugerenciaPreventiva = idSugerenciaPreventiva;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_sugerencia() {
        return fecha_sugerencia;
    }

    public void setFecha_sugerencia(LocalDate fecha_sugerencia) {
        this.fecha_sugerencia = fecha_sugerencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
