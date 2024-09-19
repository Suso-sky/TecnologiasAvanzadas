package com.taller1.Modelo;

import java.io.Serializable;


public class Municipio implements Serializable {

    private int idMunicipio;
    private String nombreMunicipio;
    private Departamento departamentoMunicipio;
    private static final long serialVersionUID = 1L;

    public Municipio(int idMunicipio, String nombreMunicipio, Departamento departamentoMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.departamentoMunicipio = departamentoMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public Departamento getDepartamentoMunicipio() {
        return departamentoMunicipio;
    }
    
    
    @Override
    public String toString() {
        return "Municipio [id=" + idMunicipio + ", name=" + nombreMunicipio + ", departamento=" + departamentoMunicipio + "]";
    }

    
}
