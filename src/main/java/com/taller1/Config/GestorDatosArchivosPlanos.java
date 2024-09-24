package com.taller1.Config;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class GestorDatosArchivosPlanos<T> implements GestorDatos<T> {

    private final String nombreArchivo;

    public GestorDatosArchivosPlanos(String nombreArchivo) {
        this.nombreArchivo = Objects.requireNonNull(nombreArchivo, "El archivo debe ser válido.");
    }

    @Override
    public void guardar(T objeto) throws IOException {
        Objects.requireNonNull(objeto, "El objeto debe ser válido.");
        try {
            FileWriter guardar = new FileWriter(nombreArchivo,true);

            guardar.write(objeto.toString());
            guardar.close();
            System.out.println("Objeto guardado.");
        } catch(IOException error) {
            System.out.println("Error al guardar: " + error.getMessage());
            throw error;
        }
    }

    @Override
    public T leer(int id) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains("id=" + id)) {
                    System.out.println(linea);
                    return null;
                    //no encontramos manera para crear un objeto a partir de un ToString
                }
            }
        } catch(IOException error) {
            System.out.println("Error al leer del archivo plano: " + error.getMessage());
            throw error;
        }
        return null;
    }

    @Override
    public void actualizar(T objeto) {
        throw new UnsupportedOperationException("Actualización no implementada para archivos planos.");
    }

    @Override
    public void eliminar(int id) throws Exception {
        File inputFile = new File(nombreArchivo);
        File tempFile = new File("temp_" + nombreArchivo);

        try(BufferedWriter ignored = new BufferedWriter(new FileWriter(nombreArchivo))){
            System.out.println("Objetos eliminados.");
        } catch(IOException error) {
            System.out.println("Error al eliminar del archivo plano: " + error.getMessage());
            throw error;
        }

        if (!inputFile.delete()) {
            throw new IOException("No se pudo eliminar el archivo original.");
        }

        if (!tempFile.renameTo(inputFile)) {
            throw new IOException("No se pudo renombrar el archivo temporal.");
        }

        System.out.println("Objeto eliminado del archivo plano.");
    }

    @Override
    public List<T> leerTodos() {
        throw new UnsupportedOperationException("Funcion no implementada para archivos planos.");
    }
}
