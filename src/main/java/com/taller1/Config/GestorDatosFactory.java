package com.taller1.Config;

import com.taller1.Modelo.Estudiante;

public class GestorDatosFactory<T>{
    public static <T> GestorDatos<T> crearGestorDatos(String tipo, String nombreArchivo, Class<T> modeloclass) {
        switch (tipo.toLowerCase()) {
            case "binario":
                return new GestorDatosArchivosBinarios<T>(nombreArchivo);
            case "plano":
                return new GestorDatosArchivosPlanos<T>(nombreArchivo);
            case "h2":
                return (GestorDatos<T>) new GestorDatosH2<T>(modeloclass);
            default:
                throw new IllegalArgumentException("Tipo de gestor de datos no válido: " + tipo);
        }
    }
}
