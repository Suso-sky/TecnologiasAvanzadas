package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Persona;

public class PersonaRepositorio extends Repositorio<Persona>{
    public PersonaRepositorio(GestorDatos<Persona> gestorDatos){
        super(gestorDatos);
    }
}
