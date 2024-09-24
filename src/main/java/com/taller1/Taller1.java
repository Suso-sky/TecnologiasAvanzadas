package com.taller1;

import com.taller1.Config.GestorDatos;
import com.taller1.Config.GestorDatosFactory;
import com.taller1.Modelo.Cargo;

public class Taller1 {
    public static void main(String[] args) throws Exception {
        // Especifica el tipo de gestor de datos que quieres utilizar (binario, plano, h2)
        String tipoGestor = "h2"; // Puedes cambiar entre "binario", "plano", "h2"
        String nombreArchivo = "cargos.dat"; // Solo se usa si es binario o plano


        GestorDatos<Cargo>  gestorDatos = GestorDatosFactory.crearGestorDatos(tipoGestor, nombreArchivo, Cargo.class);

        // Ejemplo de uso con el gestor de datos
        Cargo nuevoCargo = new Cargo(1, "Gerente");

        // Guardar cargo
        gestorDatos.guardar(nuevoCargo);

        // Obtener cargo por ID
        Cargo cargoRecuperado = gestorDatos.leer(1);
        System.out.println("Cargo recuperado: " + cargoRecuperado);

        // Actualizar cargo
        nuevoCargo = new Cargo(1, "Director");
        gestorDatos.actualizar(nuevoCargo);

        // Borrar cargo
        gestorDatos.eliminar(1);
    }
}
