package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Estudiante;

public class EstudianteRepositorio extends Repositorio<Estudiante>{
    public EstudianteRepositorio(GestorDatos<Estudiante> gestorDatos){
        super(gestorDatos);
    }
}
