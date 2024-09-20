package com.taller1.Config;

import com.taller1.Modelo.Identificable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class GestorDatosArchivosPlanos<T> implements GestorDatos<T> {

    private final String nombreArchivo;
    private final Function<String, T> mapper;

    public GestorDatosArchivosPlanos(String nombreArchivo, Function<String, T> mapper) {
        this.nombreArchivo = Objects.requireNonNull(nombreArchivo, "El archivo debe ser válido.");
        this.mapper = Objects.requireNonNull(mapper, "El mapper debe ser válido.");
    }

    @Override
    public void guardar(T objeto) throws IOException {
        Objects.requireNonNull(objeto, "El objeto debe ser válido.");
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(objeto.toString());
            bw.newLine();
            System.out.println("Objeto guardado en archivo plano.");
        }
    }

    @Override
    public T leer(int id) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                T objeto = mapper.apply(linea);
                if (objeto instanceof Identificable) {
                    if (((Identificable) objeto).getId() == id) {
                        return objeto;
                    }
                }
            }
        } catch(IOException error) {
            System.out.println("Error al leer del archivo plano: " + error.getMessage());
            throw error;
        }
        return null; // O lanzar una excepción si no se encuentra
    }

    @Override
    public void actualizar(T objeto) throws Exception {
        throw new UnsupportedOperationException("Actualización no implementada para archivos planos.");
    }

    @Override
    public void eliminar(int id) throws Exception {
        File inputFile = new File(nombreArchivo);
        File tempFile = new File("temp_" + nombreArchivo);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                T objeto = mapper.apply(linea);
                if (objeto instanceof Identificable) {
                    if (((Identificable) objeto).getId() != id) {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
            }
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
    public List<T> leerTodos() throws Exception {
        List<T> listaTabla = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                T objeto = mapper.apply(linea);
                listaTabla.add(objeto);
            }
        } catch(IOException error) {
            System.out.println("Error al leer todos del archivo plano: " + error.getMessage());
            throw error;
        }
        return listaTabla;
    }
}
