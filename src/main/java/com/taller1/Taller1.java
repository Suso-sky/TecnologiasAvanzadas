//Brandon Farid Barreto - 4701
//Juan Felipe Gonzalez - 4710
package com.taller1;

public class Taller1 {

    public static void main(String[] args) {

        System.out.println("Falta Hacer lo del controlador");
       /* Pais colombia = new Pais(1, "colombia");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(colombia, "Pais.txt");
        Pais argentina = new Pais(2, "Argentina");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(argentina, "Pais.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Pais.txt");
        GestorDatosArchivosBinarios.actualizarArchivo(colombia, "Pais.txt");
                
        Departamento meta = new Departamento(1, "Meta", colombia);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(meta, "Departamento.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Departamento.txt");
    
        Municipio villavicencio = new Municipio(1, "Villavicencio", meta);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(villavicencio, "Municipio.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Municipio.txt");

        Direccion direccion1 = new Direccion(1, villavicencio, meta, colombia, "15", "14", "SUR", "BARRIO PINILLA");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(direccion1, "Direccion.txt");
        Direccion direccion2 = new Direccion(2, villavicencio, meta, argentina, "115", "24", "NORTE", "BARRIO MANARE");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(direccion2, "Direccion.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Direccion.txt");

        Persona persona1 = new Persona(1, "Brandon", "Barreto", direccion1);
        
        Estudiante estudiante1 = new Estudiante(1, "Brandon", "Barreto", direccion1, "160004701", "Ingenieria de Sistemas", 3.7);
        Estudiante estudiante2 = new Estudiante(2, "Juan Felipe", "Mosquera", direccion1, "160004710", "Ingenieria de Sistemas", 3.8);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(estudiante1, "Estudiante.txt");
        Estudiante estudiante3 = new Estudiante(3, "Gaby", "Lopez", direccion2, "160001121", "Ingenieria Ambiental", 2.7);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(estudiante2, "Estudiante.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Estudiante.txt");

        Cargo admin = new Cargo(1, "Admin");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(admin, "Cargo.txt");
        Cargo oficial = new Cargo(2, "Oficial");
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(oficial, "Cargo.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Cargo.txt");

        Empleado empleado1 = new Empleado(1, "Brandon", "Barreto", direccion1, admin, 1000.00);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(empleado1, "Empleado.txt");
        Empleado empleado2 = new Empleado(4, "Angel", "Parra", direccion2, oficial, 2000.00);
        GestorDatosArchivosBinarios.objetoGuardarArchivoPlano(empleado2, "Empleado.txt");
        GestorDatosArchivosBinarios.leerArchivoPlano("Empleado.txt");

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
            GestorDatosArchivosBinarios.ObjetoGuardarArchivoBinario(estudiantesInscritos, "ListadoEstudiantesInscritos.bin");
            GestorDatosArchivosBinarios.leerArchivoBinario("ListadoEstudiantesInscritos.bin");
            GestorDatosArchivosBinarios.ObjetoGuardarArchivoBinario(personalInscrito, "ListadoPersonalInscrito.bin");
            GestorDatosArchivosBinarios.leerArchivoBinario("ListadoPersonalInscrito.bin");
            GestorDatosArchivosBinarios.ObjetoGuardarArchivoBinario(listadoTodos, "ListadoTodos.bin");
            GestorDatosArchivosBinarios.leerArchivoBinario("ListadoTodos.bin");

            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Cargo.txt");
            
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Departamento.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Direccion.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Empleado.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Estudiante.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Municipio.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Pais.txt");
            GestorDatosArchivosBinarios.objetosEliminarArchivoPlano("Persona.txt");

            GestorDatosArchivosBinarios.objetosEliminarArchivoBinario("ListadoEstudiantesInscritos.bin");
            GestorDatosArchivosBinarios.objetosEliminarArchivoBinario("ListadoPersonalInscrito.bin");
            GestorDatosArchivosBinarios.objetosEliminarArchivoBinario("ListadoTodos.bin");
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
    }*/

}
