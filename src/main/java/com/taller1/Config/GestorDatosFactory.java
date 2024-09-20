package com.taller1.Config;

import com.taller1.Modelo.Identificable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//aqui falta arreglar cositas
public class GestorDatosFactory {
    public static <T extends Identificable> GestorDatos<T> crearGestorDatos(String tipo, String nombreArchivo, Class<T> modeloClass) {
        switch (tipo.toLowerCase()) {
            case "binario":
                return new GestorDatosArchivosBinarios<T>(nombreArchivo);
            case "plano":
                return new GestorDatosArchivosPlanos<T>(nombreArchivo, linea -> crearInstanciaModelo(modeloClass, linea.split(",")));
            case "h2":
                return new GestorDatosH2<T>() {
                    @Override
                    protected String getAtributos() {
                        // Obtener los atributos automáticamente del modelo
                        return "*"; // Asume que se seleccionan todos los atributos
                    }

                    @Override
                    protected String getNombreTabla() {
                        return modeloClass.getSimpleName().toLowerCase() + "s"; // Nombre de la tabla
                    }

                    @Override
                    protected T mapResultSetToObject(ResultSet rs) throws SQLException {
                        return crearInstanciaDesdeResultSet(modeloClass, rs);
                    }

                    @Override
                    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, T obj) throws SQLException {
                        establecerParametros(pstmt, obj, false);
                    }

                    @Override
                    protected void setPreparedStatementParametersUpdate(PreparedStatement pstmt, T obj) throws SQLException {
                        establecerParametros(pstmt, obj, true);
                    }
                };
            default:
                throw new IllegalArgumentException("Tipo de gestor de datos no válido: " + tipo);
        }
    }

    private static <T extends Identificable> T crearInstanciaModelo(Class<T> modeloClass, String[] partes) {
        try {
            // Supongamos que el modelo tiene un constructor que recibe todos los parámetros
            // Aquí tendrías que ajustar si los tipos son diferentes
            return modeloClass.getConstructor(int.class, String.class)
                    .newInstance(Integer.parseInt(partes[0]), partes[1]);
        } catch (Exception e) {
            throw new RuntimeException("Error creando instancia del modelo", e);
        }
    }

    private static <T extends Identificable> T crearInstanciaDesdeResultSet(Class<T> modeloClass, ResultSet rs) throws SQLException {
        try {
            // Suponiendo que hay un constructor adecuado en el modelo
            return modeloClass.getConstructor(int.class, String.class)
                    .newInstance(rs.getInt("id"), rs.getString("nombre")); // Ajustar según los nombres de columnas
        } catch (Exception e) {
            throw new RuntimeException("Error creando instancia del modelo desde ResultSet", e);
        }
    }

    private static <T extends Identificable> void establecerParametros(PreparedStatement pstmt, T obj, boolean isUpdate) throws SQLException {
        // Usa reflexión para establecer los parámetros sin depender del modelo
        pstmt.setObject(1, obj.getId()); // Establece el ID
        pstmt.setObject(2, obj.getNombre()); // Establece el nombre
        if (isUpdate) {
            pstmt.setInt(3, obj.getId()); // Parámetro adicional para actualizaciones
        }
    }
}
