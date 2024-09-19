package com.taller1.DAO;

import com.taller1.Modelo.Direccion;
import com.taller1.Modelo.Estudiante;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudianteH2 extends GestorDatosH2<Estudiante>{
    
    private int idPersona;
    private String nombrePersona;
    private String apellidosPersona;
    private Direccion direccionPersona;
    private String codigoEstudiante;
    private String programaEstudiante;
    private Double promedioEstudiante;
    private static final long serialVersionUID = 1L;

    public EstudianteH2(int idPersona, String namePersona, String apellidosPersona, Direccion direccionPersona, String codigoEstudiante, String programaEstudiante,
            Double promedioEstudiante) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccionPersona;
        this.codigoEstudiante = codigoEstudiante;
        this.programaEstudiante = programaEstudiante;
        this.promedioEstudiante = promedioEstudiante;
    }
    
    @Override
    protected String getAtributos() {
        return " (idEstudiante, codigoEstudiante, programaEstudiante, promedioEstudiante)" + " VALUES " + "(?, ?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Estudiante";
    }

    @Override
    protected Estudiante mapResultSetToObject(ResultSet rs) throws SQLException {
        int idPersona = rs.getInt("idEstudiante");
        String codigoEstudiante = rs.getString("CodigoEstudiante");
        String programaEstudiante = rs.getString("programaEstudiante");
        double promedioEstudiante = rs.getDouble("promedioEstudiante");
        PersonaH2 personaH2 = new PersonaH2(0, null, null, null);
        Persona persona = new Persona(0, null, null, null);
        persona = personaH2.leer(idPersona);
        return new Estudiante(idPersona, persona.getNombrePersona(), persona.getApellidosPersona(), persona.getDireccionPersona(), codigoEstudiante, programaEstudiante, promedioEstudiante);
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Estudiante estudiante) throws SQLException {
        
        pstmt.setInt(1, estudiante.getIdPersona());
        pstmt.setString(2, estudiante.getCodigoEstudiante());
        pstmt.setString(3, estudiante.getProgramaEstudiante());
        pstmt.setDouble(4, estudiante.getPromedioEstudiante());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Estudiante estudiante, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, estudiante.getIdPersona());
    }

}
