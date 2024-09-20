package com.taller1.Config;

import com.taller1.Modelo.Identificable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorDatosArchivosBinarios<T extends Serializable> implements GestorDatos<T> {

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
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    T objeto = (T) ois.readObject();
                    if (objeto instanceof Identificable) {
                        if (((Identificable) objeto).getId() == id) {
                            return objeto;
                        }
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch(IOException | ClassNotFoundException error) {
            System.out.println("Error al leer de archivo binario: " + error.getMessage());
            throw error;
        }
        return null; // O lanzar una excepción si no se encuentra
    }

    @Override
    public void actualizar(T objeto) throws Exception {
        // Implementación específica para actualizar un objeto en archivos binarios
        throw new UnsupportedOperationException("Actualización no implementada para archivos binarios.");
    }

    @Override
    public void eliminar(int id) throws Exception {
        File inputFile = new File(nombreArchivo);
        File tempFile = new File("temp_" + nombreArchivo);

        try (FileInputStream fis = new FileInputStream(inputFile);
             ObjectInputStream ois = new ObjectInputStream(fis);
             FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            while (true) {
                try {
                    T objeto = (T) ois.readObject();
                    if (objeto instanceof Identificable) {
                        if (((Identificable) objeto).getId() != id) {
                            oos.writeObject(objeto);
                        }
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch(IOException | ClassNotFoundException error) {
            System.out.println("Error al eliminar de archivo binario: " + error.getMessage());
            throw error;
        }

        if (!inputFile.delete()) {
            throw new IOException("No se pudo eliminar el archivo original.");
        }

        if (!tempFile.renameTo(inputFile)) {
            throw new IOException("No se pudo renombrar el archivo temporal.");
        }

        System.out.println("Objeto eliminado del archivo binario.");
    }

    @Override
    public List<T> leerTodos() throws Exception {
        List<T> listaTabla = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    T objeto = (T) ois.readObject();
                    listaTabla.add(objeto);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch(IOException | ClassNotFoundException error) {
            System.out.println("Error al leer todos de archivo binario: " + error.getMessage());
            throw error;
        }
        return listaTabla;
    }
}
