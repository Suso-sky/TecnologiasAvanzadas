package com.taller1.Config;


import java.sql.Connection;
import java.sql.DriverManager;

       
public class ConexionDatos {
    
    public static Connection conectar(){
        Connection conexionBase = null;
        String rutaBase = "jdbc:h2:file:C:\\Users\\Estudiante_MCA\\Downloads\\taller1\\taller1\\taller1\\h2BD";
        String usuarioBase = "brandon";
        String contraseñaBase = "";
        
        try{
            Class.forName("org.h2.Driver");
            conexionBase = DriverManager.getConnection(rutaBase, usuarioBase, contraseñaBase);
        }catch(Exception error){
            System.out.println("Error: " + error);
        }
        return conexionBase;
    }
    
}
