package com.taller1.Config;

import java.util.List;

public interface GestorDatos<T> {
    void guardar(T objeto) throws Exception;
    T leer(int id) throws Exception;
    void actualizar(T objeto) throws Exception;
    void eliminar(int id) throws Exception;
    List<T> leerTodos() throws Exception;
}
