package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "correo", nullable = false, length = 60)
    private String correo;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "fecha_Registro", nullable = false)
    private LocalDate fecha_Registro;

    @ManyToOne
    @JoinColumn(name="idRol")
    private Rol rol;


    public Usuario() { }

    public Usuario(int idUsuario, String username, String correo, String password, boolean enabled, String telefono, LocalDate fecha_Registro, Rol rol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.enabled = enabled;
        this.telefono = telefono;
        this.fecha_Registro = fecha_Registro;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(LocalDate fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}