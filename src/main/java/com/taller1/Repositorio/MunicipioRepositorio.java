package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Municipio;

public class MunicipioRepositorio extends Repositorio<Municipio>{
    public MunicipioRepositorio(GestorDatos<Municipio> gestorDatos){
        super(gestorDatos);
    }
}
