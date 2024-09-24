package com.taller1.Config;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDatosH2<T> implements GestorDatos<T> {

    private final Class<T> modeloClass;
    private final String nombreTabla;
    private final List<Field> campos;
    private final Field campoId;

    public GestorDatosH2(Class<T> modeloClass) {
        this.modeloClass = modeloClass;
        this.nombreTabla = modeloClass.getSimpleName().toLowerCase();
        this.campos = new ArrayList<>();

        for (Field field : modeloClass.getDeclaredFields()) {
            field.setAccessible(true); // Permitir acceso a campos privados
            if (!field.getName().equalsIgnoreCase("id") && !field.getName().equalsIgnoreCase("id" + modeloClass.getSimpleName())) {
                campos.add(field);
            }
        }

        Field tempId = null;
        for (Field field : modeloClass.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("id") || field.getName().equalsIgnoreCase("id" + modeloClass.getSimpleName())) {
                tempId = field;
                tempId.setAccessible(true);
                break;
            }
        }
        if (tempId == null) {
            throw new IllegalArgumentException("La clase " + modeloClass.getSimpleName() + " debe tener un campo 'id' o 'id" + modeloClass.getSimpleName() + "'");
        }
        this.campoId = tempId;
    }

    @Override
    public void guardar(T objeto) throws Exception {
        StringBuilder columnas = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        for (Field campo : campos) {
            columnas.append(campo.getName()).append(", ");
            placeholders.append("?, ");
        }

        // Remover la última coma y espacio
        if (!columnas.isEmpty()) columnas.setLength(columnas.length() - 2);
        if (!placeholders.isEmpty()) placeholders.setLength(placeholders.length() - 2);

        String instructionSql = "INSERT INTO " + nombreTabla + " (" + columnas + ") VALUES (" + placeholders + ")";

        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instructionSql, Statement.RETURN_GENERATED_KEYS)) {

            for (int i = 0; i < campos.size(); i++) {
                pstmt.setObject(i + 1, campos.get(i).get(objeto));
            }

            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente, si es necesario
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    campoId.set(objeto, generatedKeys.getInt(1));
                }
            }

            System.out.println("Registro guardado con éxito en " + nombreTabla);
        } catch (SQLException error) {
            System.out.println("Error al guardar en " + nombreTabla + ": " + error.getMessage());
            throw error;
        }
    }

    @Override
    public T leer(int id) throws Exception {
        String instruccionSql = "SELECT * FROM " + nombreTabla + " WHERE " + campoId.getName() + " = ?";
        T objeto = null;

        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    objeto = modeloClass.getDeclaredConstructor().newInstance();
                    campoId.set(objeto, rs.getInt(campoId.getName()));

                    for (Field campo : campos) {
                        Object valor = rs.getObject(campo.getName());
                        campo.set(objeto, valor);
                    }
                }
            }

            System.out.println("Registro leído de " + nombreTabla);
        } catch (SQLException error) {
            System.out.println("Error al leer de " + nombreTabla + ": " + error.getMessage());
            throw error;
        }

        return objeto;
    }

    @Override
    public void actualizar(T objeto) throws Exception {
        StringBuilder setClause = new StringBuilder();

        for (Field campo : campos) {
            setClause.append(campo.getName()).append(" = ?, ");
        }

        // Remover la última coma y espacio
        if (!setClause.isEmpty()) setClause.setLength(setClause.length() - 2);

        String instruccionSql = "UPDATE " + nombreTabla + " SET " + setClause + " WHERE " + campoId.getName() + " = ?";

        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {

            int i = 1;
            for (Field campo : campos) {
                pstmt.setObject(i++, campo.get(objeto));
            }
            pstmt.setObject(i, campoId.get(objeto));

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Registro actualizado en " + nombreTabla);
            } else {
                System.out.println("No se encontró el registro para actualizar en " + nombreTabla);
            }

        } catch (SQLException error) {
            System.out.println("Error al actualizar en " + nombreTabla + ": " + error.getMessage());
            throw error;
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String instruccionSql = "DELETE FROM " + nombreTabla + " WHERE " + campoId.getName() + " = ?";

        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql)) {

            pstmt.setInt(1, id);

            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Registro eliminado de " + nombreTabla);
            } else {
                System.out.println("No se encontró el registro para eliminar en " + nombreTabla);
            }

        } catch (SQLException error) {
            System.out.println("Error al eliminar de " + nombreTabla + ": " + error.getMessage());
            throw error;
        }
    }

    @Override
    public List<T> leerTodos() throws Exception {
        List<T> listaTabla = new ArrayList<>();
        String instruccionSql = "SELECT * FROM " + nombreTabla;

        try (Connection conexion = ConexionDatos.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(instruccionSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                T objeto = modeloClass.getDeclaredConstructor().newInstance();
                campoId.set(objeto, rs.getInt(campoId.getName()));

                for (Field campo : campos) {
                    Object valor = rs.getObject(campo.getName());
                    campo.set(objeto, valor);
                }

                listaTabla.add(objeto);
            }

            System.out.println("Registros leídos de " + nombreTabla);
        } catch (SQLException error) {
            System.out.println("Error al leer todos de " + nombreTabla + ": " + error.getMessage());
            throw error;
        }

        return listaTabla;
    }
}
