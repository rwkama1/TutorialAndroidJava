package uy.edu.bios.gridview;

import java.io.Serializable;

/**
 * Created by Raul on 26/9/2017.
 */

public class Empleado implements Serializable {

    private int cedula;
    private String nombreCompleto;
    private String descripcion;


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Empleado() {
        this(1, "N/D", "Bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla.");
    }

    public Empleado(int cedula, String nombreCompleto) {
        this(cedula, nombreCompleto, "Bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla.");
    }

    public Empleado(int cedula, String nombreCompleto, String descripcion) {
        setCedula(cedula);
        setNombreCompleto(nombreCompleto);
        setDescripcion(descripcion);
    }


    @Override
    public String toString() {
        return getNombreCompleto();
    }

}
