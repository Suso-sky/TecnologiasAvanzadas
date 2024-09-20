package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;
import com.taller1.Modelo.Direccion;

public class DireccionRepositorio extends Repositorio<Direccion> {
    public DireccionRepositorio(GestorDatos<Direccion> gestorDatos) {
        super(gestorDatos);
    }
}
