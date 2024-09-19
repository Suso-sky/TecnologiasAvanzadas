//Brandon Farid Barreto - 4701
//Juan Felipe Gonzalez - 4710
package com.taller1;

import com.taller1.Config.GestorDatosArchivos;
import com.taller1.Modelo.Municipio;
import com.taller1.Modelo.Pais;
import com.taller1.Modelo.EstudiantesInscritos;
import com.taller1.Modelo.Direccion;
import com.taller1.Modelo.Estudiante;
import com.taller1.Modelo.ListadoTodos;
import com.taller1.Modelo.PersonalInscrito;
import com.taller1.Modelo.Cargo;
import com.taller1.Modelo.Persona;
import com.taller1.Modelo.Departamento;
import com.taller1.Modelo.Empleado;
import com.taller1.DAO.PersonaH2;
import com.taller1.DAO.DepartamentoH2;
import com.taller1.DAO.MunicipioH2;
import com.taller1.DAO.PaisH2;
import com.taller1.DAO.EmpleadoH2;
import com.taller1.DAO.EstudianteH2;
import com.taller1.DAO.CargoH2;
import com.taller1.DAO.DireccionH2;
import java.io.IOException;

public class Taller1 {

    public static void main(String[] args) {

        Pais colombia = new Pais(1, "colombia");
        GestorDatosArchivos.objetoGuardarArchivoPlano(colombia, "Pais.txt");
        Pais argentina = new Pais(2, "Argentina");
        GestorDatosArchivos.objetoGuardarArchivoPlano(argentina, "Pais.txt");
        GestorDatosArchivos.leerArchivoPlano("Pais.txt");
        GestorDatosArchivos.actualizarArchivo(colombia, "Pais.txt");
                
        Departamento meta = new Departamento(1, "Meta", colombia);
        GestorDatosArchivos.objetoGuardarArchivoPlano(meta, "Departamento.txt");
        GestorDatosArchivos.leerArchivoPlano("Departamento.txt");
    
        Municipio villavicencio = new Municipio(1, "Villavicencio", meta);
        GestorDatosArchivos.objetoGuardarArchivoPlano(villavicencio, "Municipio.txt");
        GestorDatosArchivos.leerArchivoPlano("Municipio.txt");

        Direccion direccion1 = new Direccion(1, villavicencio, meta, colombia, "15", "14", "SUR", "BARRIO PINILLA");
        GestorDatosArchivos.objetoGuardarArchivoPlano(direccion1, "Direccion.txt");
        Direccion direccion2 = new Direccion(2, villavicencio, meta, argentina, "115", "24", "NORTE", "BARRIO MANARE");
        GestorDatosArchivos.objetoGuardarArchivoPlano(direccion2, "Direccion.txt");
        GestorDatosArchivos.leerArchivoPlano("Direccion.txt");

        Persona persona1 = new Persona(1, "Brandon", "Barreto", direccion1);
        
        Estudiante estudiante1 = new Estudiante(1, "Brandon", "Barreto", direccion1, "160004701", "Ingenieria de Sistemas", 3.7);
        Estudiante estudiante2 = new Estudiante(2, "Juan Felipe", "Mosquera", direccion1, "160004710", "Ingenieria de Sistemas", 3.8);
        GestorDatosArchivos.objetoGuardarArchivoPlano(estudiante1, "Estudiante.txt");
        Estudiante estudiante3 = new Estudiante(3, "Gaby", "Lopez", direccion2, "160001121", "Ingenieria Ambiental", 2.7);
        GestorDatosArchivos.objetoGuardarArchivoPlano(estudiante2, "Estudiante.txt");
        GestorDatosArchivos.leerArchivoPlano("Estudiante.txt");

        Cargo admin = new Cargo(1, "Admin");
        GestorDatosArchivos.objetoGuardarArchivoPlano(admin, "Cargo.txt");
        Cargo oficial = new Cargo(2, "Oficial");
        GestorDatosArchivos.objetoGuardarArchivoPlano(oficial, "Cargo.txt");
        GestorDatosArchivos.leerArchivoPlano("Cargo.txt");

        Empleado empleado1 = new Empleado(1, "Brandon", "Barreto", direccion1, admin, 1000.00);
        GestorDatosArchivos.objetoGuardarArchivoPlano(empleado1, "Empleado.txt");
        Empleado empleado2 = new Empleado(4, "Angel", "Parra", direccion2, oficial, 2000.00);
        GestorDatosArchivos.objetoGuardarArchivoPlano(empleado2, "Empleado.txt");
        GestorDatosArchivos.leerArchivoPlano("Empleado.txt");

        EstudiantesInscritos estudiantesInscritos = new EstudiantesInscritos();
        estudiantesInscritos.adicionarEstudiante(estudiante1);

        PersonalInscrito personalInscrito = new PersonalInscrito();
        personalInscrito.adicionarPersonal(empleado1);

        ListadoTodos listadoTodos = new ListadoTodos();
        listadoTodos.adicionarItem(estudiante1);
        listadoTodos.adicionarItem(estudiante2);
        listadoTodos.adicionarItem(empleado1);
        listadoTodos.adicionarItem(empleado2);
        listadoTodos.adicionarItem(admin);
        listadoTodos.adicionarItem(oficial);

        try {
            GestorDatosArchivos.ObjetoGuardarArchivoBinario(estudiantesInscritos, "ListadoEstudiantesInscritos.bin");
            GestorDatosArchivos.leerArchivoBinario("ListadoEstudiantesInscritos.bin");
            GestorDatosArchivos.ObjetoGuardarArchivoBinario(personalInscrito, "ListadoPersonalInscrito.bin");
            GestorDatosArchivos.leerArchivoBinario("ListadoPersonalInscrito.bin");
            GestorDatosArchivos.ObjetoGuardarArchivoBinario(listadoTodos, "ListadoTodos.bin");
            GestorDatosArchivos.leerArchivoBinario("ListadoTodos.bin");

            GestorDatosArchivos.objetosEliminarArchivoPlano("Cargo.txt");
            
            GestorDatosArchivos.objetosEliminarArchivoPlano("Departamento.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Direccion.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Empleado.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Estudiante.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Municipio.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Pais.txt");
            GestorDatosArchivos.objetosEliminarArchivoPlano("Persona.txt");

            GestorDatosArchivos.objetosEliminarArchivoBinario("ListadoEstudiantesInscritos.bin");
            GestorDatosArchivos.objetosEliminarArchivoBinario("ListadoPersonalInscrito.bin");
            GestorDatosArchivos.objetosEliminarArchivoBinario("ListadoTodos.bin");
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace(System.out);
        }
        
       
        PaisH2 gestorDatosPais = new PaisH2(0, null);
        CargoH2 gestorDatosCargo = new CargoH2(0, null);
        DepartamentoH2 gestorDatosDepartamento = new DepartamentoH2(0, null, null);
        MunicipioH2 gestorDatosMunicipio = new MunicipioH2(0, null, null);
        DireccionH2 gestorDatosDireccion = new DireccionH2(0, null, null, null, null, null, null, null);
        PersonaH2 gestorDatosPersona = new PersonaH2(0, null, null, null);
        EstudianteH2 gestorDatosEstudiante = new EstudianteH2(0, null, null, null, null, null, null);
        EmpleadoH2 gestorDatosEmpleado = new EmpleadoH2(0, null, null, null, null, null);
        
        
        
        gestorDatosPais.crear(colombia);
        System.out.println(gestorDatosPais.leer(1));
        gestorDatosPais.actualizar(colombia, "nombrePais", "españa");

        gestorDatosCargo.crear(admin);
        System.out.println(gestorDatosCargo.leer(1));
        gestorDatosCargo.actualizar(admin, "nombreCargo", "empleado");

        gestorDatosDepartamento.crear(meta);
        System.out.println(gestorDatosDepartamento.leer(1));
        gestorDatosDepartamento.actualizar(meta, "nombreDepartamento", "cataluña");

        gestorDatosMunicipio.crear(villavicencio);
        System.out.println(gestorDatosMunicipio.leer(1));
        gestorDatosMunicipio.actualizar(villavicencio, "nombreMunicipio", "barcelona");
        
        gestorDatosDireccion.crear(direccion1);
        System.out.println(gestorDatosDireccion.leer(1));
        gestorDatosDireccion.actualizar(direccion1, "calleDireccion", "10");
        
        gestorDatosPersona.crear(persona1);
        System.out.println(gestorDatosPersona.leer(1));
        gestorDatosPersona.actualizar(persona1, "nombrePersona", "farid");
        
        gestorDatosEstudiante.crear(estudiante1);
        System.out.println(gestorDatosEstudiante.leer(1));
        gestorDatosEstudiante.actualizar(estudiante1, "PromedioEstudiante", "40");
        
        gestorDatosEmpleado.crear(empleado1);
        System.out.println(gestorDatosEmpleado.leer(1));
        gestorDatosEmpleado.actualizar(empleado1, "salarioEmpleado", 8000.00);
          

        if (true) {
            gestorDatosEmpleado.borrar(1);
            gestorDatosEstudiante.borrar(1);
            gestorDatosPersona.borrar(1);
            gestorDatosDireccion.borrar(1);
            gestorDatosMunicipio.borrar(1);
            gestorDatosDepartamento.borrar(1);
            gestorDatosPais.borrar(1);
            gestorDatosCargo.borrar(1);
        }
    }

}
