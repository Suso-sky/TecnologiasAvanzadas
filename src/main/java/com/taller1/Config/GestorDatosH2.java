
package com.taller1.Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GestorDatosH2<Objeto> {
    
    protected abstract String getAtributos();
    protected abstract String getNombreTabla();
    protected abstract Objeto mapResultSetToObject(ResultSet rs) throws SQLException;
    protected abstract void setPreparedStatementParametersSave(PreparedStatement pstmt, Objeto obj) throws SQLException;
    protected abstract <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Objeto obj, Atributo nuevoAtributo) throws SQLException;
    
    public void crear(Objeto objeto) {
        String instruccionSql = "INSERT INTO " + getNombreTabla() + getAtributos();
        try (Connection conexion = ConexionDatos.conectar();
            PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {
            setPreparedStatementParametersSave(pstmt, objeto);
            pstmt.executeUpdate();
            System.out.println("Registro guardado con exito");
        } catch (SQLException error) {
            System.out.println("Error: " + error);
            error.printStackTrace();
        }
    }
    
    public Objeto leer(int id) {
        String instruccionSql = "SELECT * FROM " + getNombreTabla() + " WHERE id" + getNombreTabla() + " = ?";
        Objeto objeto = null;
        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {
             pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    objeto = mapResultSetToObject(rs);
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return objeto;
    }
    
    public <Atributo> void actualizar(Objeto objeto, String atributoActualizar, Atributo nuevoAtributo) {
        String instruccionSql = "UPDATE " + getNombreTabla() + " SET " + atributoActualizar + " = ? WHERE id" + getNombreTabla() + " = ?" ;
        try (Connection conexion = ConexionDatos.conectar();
            PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {
            setPreparedStatementParametersUpdate(pstmt, objeto, nuevoAtributo);
            pstmt.executeUpdate();
            System.out.println("Registro Actualizado");
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
    
    public void borrar(int id) {
        String instruccionSql = "DELETE FROM " + getNombreTabla() + " WHERE id" + getNombreTabla() + " = ?";
        try (Connection conexion = ConexionDatos.conectar();
            PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Registro eliminado correctamente");
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
    
    public List<Objeto> leerTabla() {
        List<Objeto> listaTabla = new ArrayList<>();
        String instruccionSql = "SELECT * FROM " + getNombreTabla();
        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                listaTabla.add(mapResultSetToObject(rs));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return listaTabla;
    }
}

