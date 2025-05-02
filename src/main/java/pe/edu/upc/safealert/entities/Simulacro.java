package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Simulacro")
public class Simulacro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSimulacro;

    @Column(name = "titulo",nullable = false, length = 20)
    private String titulo;

    @Column(name = "fecha_simulacro",nullable = false)
    private LocalDate fecha_simulacro;

    @Column(name = "duracion_minutos",nullable = false)
    private int duracion_minutos;

    @Column(name = "tipo",nullable = false, length = 50)
    private String tipo;

    @ManyToOne
    @JoinColumn(name="idUbicacion")
    private Ubicacion ubicacion;

    public Simulacro() {
    }

    public Simulacro(int idSimulacro, String titulo, LocalDate fecha_simulacro, int duracion_minutos, String tipo, Ubicacion ubicacion) {
        this.idSimulacro = idSimulacro;
        this.titulo = titulo;
        this.fecha_simulacro = fecha_simulacro;
        this.duracion_minutos = duracion_minutos;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public int getIdSimulacro() {
        return idSimulacro;
    }

    public void setIdSimulacro(int idSimulacro) {
        this.idSimulacro = idSimulacro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha_simulacro() {
        return fecha_simulacro;
    }

    public void setFecha_simulacro(LocalDate fecha_simulacro) {
        this.fecha_simulacro = fecha_simulacro;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}


