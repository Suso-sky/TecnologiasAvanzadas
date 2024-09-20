package com.taller1.Modelo;


import java.io.Serializable;


public class Direccion implements Serializable, Identificable {
    
    private int idDireccion;
    private Municipio municipioDireccion;
    private Departamento departamentoDireccion;
    private Pais paisDireccion;
    private String calleDireccion;
    private String carreraDireccion;
    private String coordenadaDireccion;
    private String descripcionDireccion;
    private  static  final  long serialVersionUID = 1L;

    @Override
    public int getId() {
        return idDireccion;
    }

    public Direccion(int idDireccion, Municipio municipioDireccion, Departamento departamento, Pais paisDireccion, String calleDireccion, String carreraDireccion,
                     String coordenadaDireccion, String descripcionDireccion) {
        this.idDireccion = idDireccion;
        this.municipioDireccion = municipioDireccion;
        this.departamentoDireccion = departamento;
        this.paisDireccion = paisDireccion;
        this.calleDireccion = calleDireccion;
        this.carreraDireccion = carreraDireccion;
        this.coordenadaDireccion = coordenadaDireccion;
        this.descripcionDireccion = descripcionDireccion;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public Municipio getMunicipioDireccion() {
        return municipioDireccion;
    }

    public Departamento getDepartamentoDireccion() {
        return departamentoDireccion;
    }

    public Pais getPaisDireccion() {
        return paisDireccion;
    }

    public String getCalleDireccion() {
        return calleDireccion;
    }

    public String getCarreraDireccion() {
        return carreraDireccion;
    }

    public String getCoordenadaDireccion() {
        return coordenadaDireccion;
    }

    public String getDescripcionDireccion() {
        return descripcionDireccion;
    }
    
    @Override
    public String toString() {
        return "Direccion [id=" + idDireccion + ", municipio=" + municipioDireccion + ", departamento=" + departamentoDireccion + ", pais=" + paisDireccion
                + ", calle=" + calleDireccion + ", carrera=" + carreraDireccion + ", coordenada=" + coordenadaDireccion + ", descripcion="
                + descripcionDireccion + "]";
    }

}