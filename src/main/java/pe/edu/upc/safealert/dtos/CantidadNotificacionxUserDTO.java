package pe.edu.upc.safealert.dtos;

public class CantidadNotificacionxUserDTO {

    private String username;
    private int cantidad;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}