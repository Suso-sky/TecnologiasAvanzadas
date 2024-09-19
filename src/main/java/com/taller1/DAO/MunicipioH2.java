
package com.taller1.DAO;

import com.taller1.Modelo.Departamento;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Municipio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipioH2 extends GestorDatosH2<Municipio>{
    
    private int idMunicipio;
    private String nombreMunicipio;
    private Departamento departamentoMunicipio;
    private static final long serialVersionUID = 1L;

    public MunicipioH2(int idMunicipio, String nombreMunicipio, Departamento departamentoMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.departamentoMunicipio = departamentoMunicipio;
    }
    
    @Override
    protected String getAtributos() {
        return " (nombreMunicipio, idMunicipio, departamentoMunicipio)" + " VALUES " + "(?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Municipio";
    }

    @Override
    protected Municipio mapResultSetToObject(ResultSet rs) throws SQLException {
        int idMunicipio = rs.getInt("idMunicipio");
        String nombreMunicipio = rs.getString("nombreMunicipio");
        int departamentoMunicipio = rs.getInt("departamentoMunicipio");
        DepartamentoH2 departamento = new DepartamentoH2(0, null, null);
        return new Municipio(idMunicipio, nombreMunicipio, departamento.leer(departamentoMunicipio));
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Municipio municipio) throws SQLException {
        pstmt.setString(1, municipio.getNombreMunicipio());
        pstmt.setInt(2, municipio.getIdMunicipio());
        pstmt.setInt(3, municipio.getDepartamentoMunicipio().getIdDepartamento());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Municipio municipio, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, municipio.getIdMunicipio());
    }
}
