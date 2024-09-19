package com.taller1.Modelo;

import java.io.Serializable;


public class Departamento implements Serializable {

    private int idDepartamento;
    private String nombreDepartamento;
    private Pais paisDepartamento;
    private static final long serialVersionUID = 1L;

    public Departamento(int idDepartamento, String nombreDepartamento, Pais paisDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.paisDepartamento = paisDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    

    public Pais getPaisDepartamento() {
        return paisDepartamento;
    }

    @Override
    public String toString() {
        return "Departamento [id=" + idDepartamento + ", name=" + nombreDepartamento + ", pais=" + paisDepartamento + "]";
    }

    
}
