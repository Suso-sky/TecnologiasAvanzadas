
package com.taller1.DAO;

import com.taller1.Modelo.Departamento;
import com.taller1.Modelo.Direccion;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Municipio;
import com.taller1.Modelo.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DireccionH2 extends GestorDatosH2<Direccion>{
    
    private int idDireccion;
    private Municipio municipioDireccion;
    private Departamento departamentoDireccion;
    private Pais paisDireccion;
    private String calleDireccion;
    private String carreraDireccion;
    private String coordenadaDireccion;
    private String descripcionDireccion;
    private  static  final  long serialVersionUID = 1L;


    public DireccionH2(int idDireccion, Municipio municipioDireccion, Departamento departamento, Pais paisDireccion, String calleDireccion, String carreraDireccion,
                     String coordenadaDireccion, String descripcionDireccion) {
        this.idDireccion = idDireccion;
        this.municipioDireccion = municipioDireccion;
        this.departamentoDireccion = departamento;
        this.paisDireccion = paisDireccion;
        this.calleDireccion = calleDireccion;
        this.carreraDireccion = carreraDireccion;
        this.coordenadaDireccion = coordenadaDireccion;
        this.descripcionDireccion = descripcionDireccion;
    }
    
    @Override
    protected String getAtributos() {
        return " (idDireccion, municipioDireccion, departamentoDireccion, paisDireccion, calleDireccion, carreraDireccion, coordenadaDireccion, descripcionDireccion)" + " VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Direccion";
    }

    @Override
    protected Direccion mapResultSetToObject(ResultSet rs) throws SQLException {
        int idDireccion = rs.getInt("idDireccion");
        int municipioDireccion = rs.getInt("municipioDireccion");
        int departamentoDireccion = rs.getInt("departamentoDireccion");
        int paisDireccion = rs.getInt("paisDireccion");
        String calleDireccion = rs.getString("calleDireccion");
        String carreraDireccion = rs.getString("carreraDireccion");
        String coordenadaDireccion = rs.getString("coordenadaDireccion");
        String descripcionDireccion = rs.getString("descripcionDireccion");
        MunicipioH2 municipio = new MunicipioH2(0,null,null);
        DepartamentoH2 departamento = new DepartamentoH2(0, null, null);
        PaisH2 pais = new PaisH2(0, null);
        return new Direccion(idDireccion, municipio.leer(municipioDireccion), departamento.leer(departamentoDireccion), pais.leer(paisDireccion), calleDireccion, carreraDireccion, coordenadaDireccion, descripcionDireccion);
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Direccion direccion) throws SQLException {
        pstmt.setInt(1, direccion.getIdDireccion());
        pstmt.setInt(2, direccion.getMunicipioDireccion().getIdMunicipio());
        pstmt.setInt(3, direccion.getDepartamentoDireccion().getIdDepartamento());
        pstmt.setInt(4, direccion.getPaisDireccion().getIdPais());
        pstmt.setString(5, direccion.getCalleDireccion());
        pstmt.setString(6, direccion.getCarreraDireccion());
        pstmt.setString(7, direccion.getCoordenadaDireccion());
        pstmt.setString(8, direccion.getDescripcionDireccion());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Direccion direccion, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, direccion.getIdDireccion());
    }
}
