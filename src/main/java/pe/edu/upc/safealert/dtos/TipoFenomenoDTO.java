package pe.edu.upc.safealert.dtos;

import pe.edu.upc.safealert.entities.FenomenoNatural;

public class TipoFenomenoDTO {

    private int idTipoFenomeno;
    private String nombre_tipo;
    private String descripcion;
    private FenomenoNatural fenomenoNatural;

    public int getIdTipoFenomeno() {
        return idTipoFenomeno;
    }

    public void setIdTipoFenomeno(int idTipoFenomeno) {
        this.idTipoFenomeno = idTipoFenomeno;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FenomenoNatural getFenomenoNatural() {
        return fenomenoNatural;
    }

    public void setFenomenoNatural(FenomenoNatural fenomenoNatural) {
        this.fenomenoNatural = fenomenoNatural;
    }
}
