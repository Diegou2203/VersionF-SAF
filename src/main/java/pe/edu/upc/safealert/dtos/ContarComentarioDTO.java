package pe.edu.upc.safealert.dtos;

public class ContarComentarioDTO {
    private String nombre;
    private int contarcomentario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContarcomentario() {
        return contarcomentario;
    }

    public void setContarcomentario(int contarcomentario) {
        this.contarcomentario = contarcomentario;
    }
}