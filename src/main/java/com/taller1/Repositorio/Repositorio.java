package com.taller1.Repositorio;

import com.taller1.Config.GestorDatos;

import java.util.List;

public class Repositorio<T> {
    private final GestorDatos<T> gestorDatos;

    public Repositorio(GestorDatos<T> gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    public void guardar(T objeto) throws Exception {
        gestorDatos.guardar(objeto);
    }

    public T leer(int id) throws Exception {
        return gestorDatos.leer(id);
    }

    public void actualizar(T objeto) throws Exception {
        gestorDatos.actualizar(objeto);
    }

    public void eliminar(int id) throws Exception {
        gestorDatos.eliminar(id);
    }

    public List<T> leerTodos() throws Exception {
        return gestorDatos.leerTodos();
    }
}
