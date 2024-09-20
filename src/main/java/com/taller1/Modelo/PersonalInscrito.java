package com.taller1.Modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class PersonalInscrito implements Serializable {
    private List<Persona> listadoPersonal;
    private  static  final  long serialVersionUID = 1L;

    public PersonalInscrito() {
        this.listadoPersonal = new ArrayList<>();
    }

    public void adicionarPersonal(Persona persona) {
        if (persona != null) {
            listadoPersonal.add(persona);
        }
    }

    public void imprimirListadoPersonal() {
        for (Persona persona : listadoPersonal) {
            System.out.println(persona);
        }
    }

    @Override
    public String toString() {
        return "PersonalInscrito [listado=" + listadoPersonal + "]";
    }
    
}

