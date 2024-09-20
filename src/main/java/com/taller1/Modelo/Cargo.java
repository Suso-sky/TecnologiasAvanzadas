package com.taller1.Modelo;

public class Cargo implements Todos, Identificable {

    private int idCargo;
    private String nombreCargo;

    private static final long serialVersionUID = 1L;

    public Cargo(int idCargo, String nombreCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }

    @Override
    public int getId() {
        return idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    @Override
    public String toString() {
        return "Cargo [id=" + idCargo + ", nombre=" + nombreCargo + "]";
    }

    @Override
    public String information() {
        return toString();
    }
}
