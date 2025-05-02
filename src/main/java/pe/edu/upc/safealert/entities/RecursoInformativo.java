package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecursoInformativo")
public class RecursoInformativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecursoInformativo;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "titulo", nullable = false, length = 35)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "url", nullable = false, length = 70)
    private String url;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fecha_publicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public RecursoInformativo() {
    }

    public RecursoInformativo(int idRecursoInformativo, String tipo, String titulo, String descripcion, String url, LocalDate fecha_publicacion, Usuario usuario) {
        this.idRecursoInformativo = idRecursoInformativo;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.fecha_publicacion = fecha_publicacion;
        this.usuario = usuario;
    }

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
