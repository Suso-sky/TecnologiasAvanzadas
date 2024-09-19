package com.taller1.Modelo;

import java.io.Serializable;


public class Estudiante extends Persona implements Serializable {

    private String codigoEstudiante;
    private String programaEstudiante;
    private Double promedioEstudiante;
    private static final long serialVersionUID = 1L;

    public Estudiante(int idPersona, String namePersona, String apellidosPersona, Direccion direccionPersona, String codigoEstudiante, String programaEstudiante,
            Double promedioEstudiante) {
        super(idPersona, namePersona, apellidosPersona, direccionPersona);
        this.codigoEstudiante = codigoEstudiante;
        this.programaEstudiante = programaEstudiante;
        this.promedioEstudiante = promedioEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + getIdPersona() + ", nombres=" + getNombrePersona() + ", apellidos=" + getApellidosPersona()
                + ", direccion=" + getDireccionPersona() + ", codigo=" + codigoEstudiante + ", programa=" + programaEstudiante + ", promedio=" + promedioEstudiante + "]";
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getProgramaEstudiante() {
        return programaEstudiante;
    }

    public Double getPromedioEstudiante() {
        return promedioEstudiante;
    }

    
}
