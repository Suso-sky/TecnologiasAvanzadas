package com.taller1.Config;

public class GestorDatosFactory {
    public static <T> GestorDatos<T> crearGestorDatos(String tipo, String nombreArchivo, Class<T> modeloclass) {
        return switch (tipo.toLowerCase()) {
            case "binario" -> new GestorDatosArchivosBinarios<>(nombreArchivo);
            case "plano" -> new GestorDatosArchivosPlanos<>(nombreArchivo);
            case "h2" -> new GestorDatosH2<>(modeloclass);
            default -> throw new IllegalArgumentException("Tipo de gestor de datos no válido: " + tipo);
        };
    }
}
