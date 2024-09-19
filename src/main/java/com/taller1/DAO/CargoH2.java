
package com.taller1.DAO;

import com.taller1.Modelo.Cargo;
import com.taller1.Config.GestorDatosH2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CargoH2 extends GestorDatosH2<Cargo>{
    private int idCargo;
    private String nombreCargo;
    
    public CargoH2(int idCargo, String nombreCargo) {
            this.idCargo = idCargo;
            this.nombreCargo = nombreCargo;
        }
    
    @Override
        protected String getAtributos() {
            return " (nombreCargo, idCargo)" + " VALUES " + "(?, ?)";
        }

        @Override
        protected String getNombreTabla() {
            return "Cargo";
        }

        @Override
        protected Cargo mapResultSetToObject(ResultSet rs) throws SQLException {
            int idCargo = rs.getInt("idCargo");
            String nombreCargo = rs.getString("nombreCargo");
            return new Cargo(idCargo, nombreCargo);
        }

        @Override
        protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Cargo cargo) throws SQLException {
            pstmt.setString(1, cargo.getNombreCargo());
            pstmt.setInt(2, cargo.getIdCargo());
        }

        @Override
        protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Cargo cargo, Atributo nuevoAtributo) throws SQLException {
            pstmt.setObject(1, nuevoAtributo);
            pstmt.setInt(2, cargo.getIdCargo());
        }
}
