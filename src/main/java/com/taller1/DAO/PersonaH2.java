package com.taller1.DAO;

import com.taller1.Modelo.Direccion;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaH2 extends GestorDatosH2<Persona> {

    private int idPersona;
    private String nombrePersona;
    private String apellidosPersona;
    private Direccion direccionPersona;
    private static final long serialVersionUID = 1L;

    public PersonaH2(int idPersona, String nombrePersona, String apellidosPersona, Direccion direccionPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccionPersona;
    }
    
    @Override
    protected String getAtributos() {
        return " (idPersona, nombrePersona, apellidosPersona, direccionPersona)" + " VALUES " + "(?, ?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Persona";
    }

    @Override
    protected Persona mapResultSetToObject(ResultSet rs) throws SQLException {
        int idPersona = rs.getInt("idPersona");
        String nombrePersona = rs.getString("nombrePersona");
        String apellidosPersona = rs.getString("apellidosPersona");
        int direccionPersona = rs.getInt("direccionPersona");
        DireccionH2 direccion = new DireccionH2(0, null, null, null, null, null, null, null);
        return new Persona(idPersona, nombrePersona, apellidosPersona, direccion.leer(direccionPersona));
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Persona persona) throws SQLException {
        pstmt.setInt(1, persona.getIdPersona());
        pstmt.setString(2, persona.getNombrePersona());
        pstmt.setString(3, persona.getApellidosPersona());
        pstmt.setInt(4, persona.getDireccionPersona().getIdDireccion());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Persona persona, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, persona.getIdPersona());
    }
}
