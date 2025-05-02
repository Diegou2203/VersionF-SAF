package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecordatorioSimulacro")
public class RecordatorioSimulacro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecordatorioSimulacro;

    @Column(name = "fecha_recordatorio", nullable = false)
    private LocalDate fecha_recordatorio;

    @Column(name = "metodo_envio", nullable = false, length = 40)
    private String metodo_envio;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idSimulacro")
    private Simulacro simulacro;

    public RecordatorioSimulacro() { }

    public RecordatorioSimulacro(int idRecordatorioSimulacro, LocalDate fecha_recordatorio, String metodo_envio, String estado, Simulacro simulacro) {
        this.idRecordatorioSimulacro = idRecordatorioSimulacro;
        this.fecha_recordatorio = fecha_recordatorio;
        this.metodo_envio = metodo_envio;
        this.estado = estado;
        this.simulacro = simulacro;
    }

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
