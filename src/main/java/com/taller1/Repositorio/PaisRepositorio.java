package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Pais;

public class PaisRepositorio extends Repositorio<Pais>{
    public PaisRepositorio(GestorDatos<Pais> gestorDatos){
        super(gestorDatos);
    }
}
