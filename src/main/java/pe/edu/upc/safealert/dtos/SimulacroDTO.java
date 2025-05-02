package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Ubicacion;

import java.time.LocalDate;

public class SimulacroDTO {

    private int idSimulacro;
    private String titulo;
    private LocalDate fecha_simulacro;
    private int duracion_minutos;
    private String tipo;
    private Ubicacion ubicacion;

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

