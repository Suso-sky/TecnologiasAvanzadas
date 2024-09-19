package com.taller1.Config;

import java.io.*;
import java.util.Objects;


public class GestorDatosArchivos{

    public static void objetoGuardarArchivoPlano(Object objeto, String nombreArchivo){
        Objects.requireNonNull(objeto, "El objeto debe ser valido.");
        Objects.requireNonNull(nombreArchivo,"El archivo debe ser valido.");

        try {
            FileWriter guardar = new FileWriter(nombreArchivo,true);

            guardar.write(objeto.toString());
            guardar.close();
            System.out.println("Objeto guardado.");
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }

    public static void ObjetoGuardarArchivoBinario(Object objeto, String nombreArchivo)throws IOException, ClassNotFoundException{

        Objects.requireNonNull(objeto, "El objeto debe ser valido.");
        Objects.requireNonNull(nombreArchivo,"El archivo debe ser valido.");
        
        try(FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            ObjectOutputStream guardar = new ObjectOutputStream(archivo)){
            guardar.writeObject(objeto);
            System.out.println("Objeto guardado.");
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }
    
    public  static void leerArchivoPlano(String nombreArchivo){
        Objects.requireNonNull(nombreArchivo, "El archivo debe ser valido.");
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader lineaLeida = new BufferedReader(new FileReader(archivo));
            String lecturaLinea = lineaLeida.readLine();
            while (lecturaLinea!=null){
                System.out.println(lecturaLinea);
                lecturaLinea=lineaLeida.readLine();
            }
            lineaLeida.close();
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivoBinario(String nombreArchivo) throws IOException, ClassNotFoundException{
        Objects.requireNonNull(nombreArchivo, "El archivo debe ser valido.");

        try (FileInputStream archivo = new FileInputStream(nombreArchivo);
             ObjectInputStream mostrar = new ObjectInputStream(archivo)) {
            System.out.println(mostrar.readObject());
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }

    public static void actualizarArchivo(Object objeto, String nombreArchivo){
        Objects.requireNonNull(objeto, "El objeto debe ser valido.");
        Objects.requireNonNull(nombreArchivo,"El archivo debe ser valido.");
        System.out.println("Objeto actualizado");
    }
    
    public static void objetosEliminarArchivoPlano(String nombreArchivo) {
        Objects.requireNonNull(nombreArchivo, "El archivo debe ser valido.");
        
        try(BufferedWriter eliminar = new BufferedWriter(new FileWriter(nombreArchivo))){ 
            System.out.println("Objetos eliminados.");
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }
    
    public static void objetosEliminarArchivoBinario(String nombreArchivo) {
        Objects.requireNonNull(nombreArchivo, "El archivo debe ser valido.");
        
        try(FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            ObjectOutputStream eliminar = new ObjectOutputStream(archivo)){
            System.out.println("Objetos eliminados.");
        }catch (IOException exception){
            exception.printStackTrace(System.out);
        }
    }
}
