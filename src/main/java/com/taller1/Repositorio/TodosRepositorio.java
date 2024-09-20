package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Todos;

public class TodosRepositorio extends Repositorio<Todos>{
    public TodosRepositorio(GestorDatos<Todos> gestorDatos){
        super(gestorDatos);
    }
}
