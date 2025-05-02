package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SugerenciaPreventiva")
public class SugerenciaPreventiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSugerenciaPreventiva;

    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name="fecha_sugerencia", nullable = false)
    private LocalDate fecha_sugerencia;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public SugerenciaPreventiva() {}

    public SugerenciaPreventiva(int idSugerenciaPreventiva, String area, String descripcion, LocalDate fecha_sugerencia, Usuario usuario) {
        this.idSugerenciaPreventiva = idSugerenciaPreventiva;
        this.area = area;
        this.descripcion = descripcion;
        this.fecha_sugerencia = fecha_sugerencia;
        this.usuario = usuario;
    }

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
