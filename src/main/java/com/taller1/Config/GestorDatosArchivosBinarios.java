package com.taller1.Config;



import java.io.*;
import java.util.List;
import java.util.Objects;

public class GestorDatosArchivosBinarios<T> implements GestorDatos<T> {

    private final String nombreArchivo;

    public GestorDatosArchivosBinarios(String nombreArchivo) {
        this.nombreArchivo = Objects.requireNonNull(nombreArchivo, "El archivo debe ser válido.");
    }

    @Override
    public void guardar(T objeto) throws IOException {
        Objects.requireNonNull(objeto, "El objeto debe ser válido.");
        try (FileOutputStream fos = new FileOutputStream(nombreArchivo, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(objeto);
            System.out.println("Objeto guardado en archivo binario.");
        } catch(IOException error) {
            System.out.println("Error al guardar en archivo binario: " + error.getMessage());
            throw error;
        }
    }

    @Override
    public T leer(int id) throws Exception {
        try (FileInputStream archivo = new FileInputStream(nombreArchivo);
             ObjectInputStream mostrar = new ObjectInputStream(archivo)) {
            System.out.println(mostrar.readObject());
        } catch(IOException | ClassNotFoundException error) {
            System.out.println("Error al leer de archivo binario: " + error.getMessage());
            throw error;
        }
        return null;
    }

    @Override
    public void actualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Actualización no implementada para archivos binarios.");
    }

    @Override
    public void eliminar(int id) throws Exception {
        try(FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            ObjectOutputStream eliminar = new ObjectOutputStream(archivo)){
            System.out.println("Objetos eliminados.");
        } catch(IOException error) {
            System.out.println("Error al eliminar archivo binario: " + error.getMessage());
            throw error;
        }
    }

    @Override
    public List<T> leerTodos() throws Exception {
        throw new UnsupportedOperationException("Funcion no implementada para archivos binarios.");
    }
}
