package com.taller1.Modelo;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;



public class EstudiantesInscritos implements Serializable {
    private List<Estudiante> listadoEstudiantes;
    private  static  final  long serialVersionUID = 1L;


    public EstudiantesInscritos() {
        this.listadoEstudiantes = new ArrayList<>();
    }

    public void adicionarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            listadoEstudiantes.add(estudiante);
        }
    }

    public void imprimirListadoEstudiantes() {
        for (Estudiante estudiante : listadoEstudiantes) {
            System.out.println(estudiante);
        }
    }

    @Override
    public String toString() {
        return "EstudiantesInscritos [listado=" + listadoEstudiantes + "]";
    }
    
}