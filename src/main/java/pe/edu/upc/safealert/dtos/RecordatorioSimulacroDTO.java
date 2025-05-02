package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Simulacro;

import java.time.LocalDate;

public class RecordatorioSimulacroDTO {

    private int idRecordatorioSimulacro;
    private LocalDate fecha_recordatorio;
    private String metodo_envio;
    private String estado;
    private Simulacro simulacro;

    public int getIdRecordatorioSimulacro() {
        return idRecordatorioSimulacro;
    }

    public void setIdRecordatorioSimulacro(int idRecordatorioSimulacro) {
        this.idRecordatorioSimulacro = idRecordatorioSimulacro;
    }

    public LocalDate getFecha_recordatorio() {
        return fecha_recordatorio;
    }

    public void setFecha_recordatorio(LocalDate fecha_recordatorio) {
        this.fecha_recordatorio = fecha_recordatorio;
    }

    public String getMetodo_envio() {
        return metodo_envio;
    }

    public void setMetodo_envio(String metodo_envio) {
        this.metodo_envio = metodo_envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Simulacro getSimulacro() {
        return simulacro;
    }

    public void setSimulacro(Simulacro simulacro) {
        this.simulacro = simulacro;
    }
}
