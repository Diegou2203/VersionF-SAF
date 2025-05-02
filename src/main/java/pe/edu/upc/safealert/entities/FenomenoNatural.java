package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="FenomenoNatural")
public class FenomenoNatural {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFenomenoNatural;

    @Column(name = "nombre_fenomeno",nullable = false, length = 30)
    private String nombre_fenomeno;

    @Column(name = "intensidad",nullable = false, length = 10)
    private String intensidad;

    @Column(name="fecha_fenomeno",nullable = false)
    private LocalDate fecha_fenomeno;

    @Column(name = "activo",nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="idUbicacion")
    private Ubicacion ubicacion;


    public FenomenoNatural() {
    }

    public FenomenoNatural(int idFenomenoNatural, String nombre_fenomeno, String intensidad, LocalDate fecha_fenomeno, boolean activo, Ubicacion ubicacion) {
        this.idFenomenoNatural = idFenomenoNatural;
        this.nombre_fenomeno = nombre_fenomeno;
        this.intensidad = intensidad;
        this.fecha_fenomeno = fecha_fenomeno;
        this.activo = activo;
        this.ubicacion = ubicacion;
    }

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
