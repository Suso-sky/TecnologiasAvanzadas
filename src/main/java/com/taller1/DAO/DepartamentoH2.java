package com.taller1.DAO;
import com.taller1.Modelo.Departamento;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoH2 extends GestorDatosH2<Departamento>{

    private int idDepartamento;
    private String nombreDepartamento;
    private Pais paisDepartamento;
    
    public DepartamentoH2(int idDepeartamento, String nombreDepartamento, Pais paisDepartamento) {
        this.idDepartamento = idDepeartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.paisDepartamento = paisDepartamento;
    }
    
    @Override
    protected String getAtributos() {
        return " (nombreDepartamento, idDepartamento, paisDepartamento)" + " VALUES " + "(?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Departamento";
    }

    @Override
    protected Departamento mapResultSetToObject(ResultSet rs) throws SQLException {
        int idDepartamento = rs.getInt("idDepartamento");
        String nombreDepartamento = rs.getString("nombreDepartamento");
        int paisDepartamento = rs.getInt("paisDepartamento");
        PaisH2 pais = new PaisH2(0,null);
        return new Departamento(idDepartamento, nombreDepartamento, pais.leer(paisDepartamento));
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Departamento departamento) throws SQLException {
        pstmt.setString(1, departamento.getNombreDepartamento());
        pstmt.setInt(2, departamento.getIdDepartamento());
        pstmt.setInt(3, departamento.getPaisDepartamento().getIdPais());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Departamento departamento, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, departamento.getIdDepartamento());
    }
    
}
