package com.taller1.Modelo;


import java.io.Serializable;



public class Persona implements Todos, Serializable {
    
    private int idPersona;
    private String nombrePersona;
    private String apellidosPersona;
    private Direccion direccionPersona;
    private  static  final  long serialVersionUID = 1L;


    public Persona(int idPersona, String nombrePersona, String apellidosPersona, Direccion direccionPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccionPersona;
    }

    @Override
    public String toString() {
        return "Persona [id=" + idPersona + ", nombres=" + nombrePersona + ", apellidos=" + apellidosPersona + ", direccion=" + direccionPersona + "]";
    }

    @Override
    public String information() {
        return toString();  
    }
    
    public int getIdPersona() {
        return idPersona;
    }
    
    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public Direccion getDireccionPersona() {
        return direccionPersona;
    }
    
}