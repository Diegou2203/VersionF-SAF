package pe.edu.upc.safealert.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "Descripcion", nullable = false,length = 35)
    private String Descripcion;

    public Rol() {
    }

    private String rol;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Rol(int idRol, String descripcion) {
        this.idRol = idRol;
        Descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
