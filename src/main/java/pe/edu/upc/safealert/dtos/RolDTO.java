package pe.edu.upc.safealert.dtos;


import pe.edu.upc.safealert.entities.Usuario;

public class RolDTO {

    private int idRol;
    private String rol;
    private Usuario usuario;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
