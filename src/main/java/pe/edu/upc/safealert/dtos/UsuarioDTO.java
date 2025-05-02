package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.Rol;

import java.time.LocalDate;

public class UsuarioDTO {
    private int idUsuario;
    private String username;
    private String correo;
    private String password;
    private boolean enabled;
    private String telefono;
    private LocalDate fecha_Registro;
    private Rol rol;

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
