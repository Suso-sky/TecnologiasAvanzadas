
package com.taller1.DAO;

import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PaisH2 extends GestorDatosH2<Pais>{
    private int idPais;
    private String nombrePais;
    private  static  final  long serialVersionUID = 1L;

    
    public PaisH2(int idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }
    
    @Override
    protected String getAtributos(){
        return " (nombrePais, idPais)" + " VALUES " + "(?, ?)";
    }
    
    @Override
    protected String getNombreTabla() {
        return "Pais";
    }
    
    @Override
    protected Pais mapResultSetToObject(ResultSet rs) throws SQLException {
        int idPais = rs.getInt("idPais");
        String nombrePais = rs.getString("nombrePais");
        return new Pais(idPais, nombrePais);
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Pais pais) throws SQLException {
        pstmt.setString(1, pais.getNombrePais());
        pstmt.setInt(2, pais.getIdPais());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Pais pais, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, pais.getIdPais());
    }
}
