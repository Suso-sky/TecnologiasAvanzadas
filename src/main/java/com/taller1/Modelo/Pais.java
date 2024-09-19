package com.taller1.Modelo;


import java.io.Serializable;



public class Pais implements Serializable  {
    private int idPais;
    private String nombrePais;
    private  static  final  long serialVersionUID = 1L;

    
    public Pais(int idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }
    
    @Override
    public String toString() {
        return "Pais [id=" + idPais + ", name=" + nombrePais + "]";
    }

    public String getNombrePais() {
        return nombrePais;
    }

    
    public int getIdPais() {
        return idPais;
    }
    
}
