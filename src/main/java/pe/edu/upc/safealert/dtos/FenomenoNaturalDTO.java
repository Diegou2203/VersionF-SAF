package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Ubicacion;

import java.time.LocalDate;

public class FenomenoNaturalDTO {
    private int idFenomenoNatural;
    private String nombre_fenomeno;
    private String intensidad;
    private LocalDate fecha_fenomeno;
    private boolean activo;
    private Ubicacion ubicacion;

    public int getIdFenomenoNatural() {
        return idFenomenoNatural;
    }

    public void setIdFenomenoNatural(int idFenomenoNatural) {
        this.idFenomenoNatural = idFenomenoNatural;
    }

    public String getNombre_fenomeno() {
        return nombre_fenomeno;
    }

    public void setNombre_fenomeno(String nombre_fenomeno) {
        this.nombre_fenomeno = nombre_fenomeno;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public LocalDate getFecha_fenomeno() {
        return fecha_fenomeno;
    }

    public void setFecha_fenomeno(LocalDate fecha_fenomeno) {
        this.fecha_fenomeno = fecha_fenomeno;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
