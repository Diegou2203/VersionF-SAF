package pe.edu.upc.safealert.dtos;

public class UsuariosAltoRiesgoDTO {
    private String username;
    private String telefono;
    private String correo;
    private String ciudad;

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCorreo() {
        return correo;
    }
}
