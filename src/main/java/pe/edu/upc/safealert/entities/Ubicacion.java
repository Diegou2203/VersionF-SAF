package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacion;

    @Column(name = "latitud",nullable = false)
    private double latitud;

    @Column(name = "longitud",nullable = false)
    private double longitud;

    @Column(name = "altitud",nullable = false)
    private double altitud;

    @Column(name = "ciudad",nullable = false,length = 20)
    private String ciudad;

    @Column(name = "region",nullable = false,length = 20)
    private String region;

    @Column(name = "pais",nullable = false,length = 20)
    private String pais;

    @Column(name = "codigo_postal",nullable = false,length = 5)
    private String codigo_postal;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario Usuario;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, double latitud, double longitud, double altitud, String ciudad, String region, String pais, String codigo_postal, Usuario usuario) {
        this.idUbicacion = idUbicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigo_postal = codigo_postal;
        Usuario = usuario;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }
}

