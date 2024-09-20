package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Departamento;

public class DepartamentoRepositorio extends Repositorio<Departamento>{
    public DepartamentoRepositorio(GestorDatos<Departamento> gestorDatos){
        super(gestorDatos);
    }
}
