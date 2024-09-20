package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Empleado;

public class EmpleadoRepositorio extends Repositorio<Empleado>{
    public EmpleadoRepositorio(GestorDatos<Empleado> gestorDatos){
        super(gestorDatos);
    }
}
