
package com.taller1.DAO;

import com.taller1.Modelo.Cargo;
import com.taller1.Modelo.Direccion;
import com.taller1.Modelo.Empleado;
import com.taller1.Config.GestorDatosH2;
import com.taller1.Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoH2 extends GestorDatosH2<Empleado>{
    private int idPersona;
    private String nombrePersona;
    private String apellidosPersona;
    private Direccion direccionPersona;
    private Cargo cargoEmpleado;
    private Double salarioEmpleado;
    private  static  final  long serialVersionUID = 1L;


    public EmpleadoH2(int idPersona, String nombresPersona, String apellidosPersona, Direccion direccion, Cargo cargoEmpleado, Double salarioEmpleado) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccion;
        this.cargoEmpleado = cargoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }
    
    @Override
    protected String getAtributos() {
        return " (idEmpleado, cargoEmpleado, salarioEmpleado)" + " VALUES " + "(?, ?, ?)";
    }

    @Override
    protected String getNombreTabla() {
        return "Empleado";
    }

    @Override
    protected Empleado mapResultSetToObject(ResultSet rs) throws SQLException {
        int idPersona = rs.getInt("idEmpleado");
        int cargoEmpleado = rs.getInt("cargoEmpleado");
        double salarioEmpleado = rs.getDouble("salarioEmpleado");
        PersonaH2 personaH2 = new PersonaH2(0, null, null, null);
        Persona persona = new Persona(0, null, null, null);
        persona = personaH2.leer(idPersona);
        CargoH2 cargo = new CargoH2(0,null);
        return new Empleado(idPersona, persona.getNombrePersona(), persona.getApellidosPersona(), persona.getDireccionPersona(), cargo.leer(cargoEmpleado), salarioEmpleado);
    }

    @Override
    protected void setPreparedStatementParametersSave(PreparedStatement pstmt, Empleado empleado) throws SQLException {        
        pstmt.setInt(1, empleado.getIdPersona());
        pstmt.setInt(2, empleado.getCargoEmpleado().getIdCargo());
        pstmt.setDouble(3, empleado.getSalarioEmpleado());
    }
    
    @Override
    protected <Atributo> void setPreparedStatementParametersUpdate(PreparedStatement pstmt, Empleado empleado, Atributo nuevoAtributo) throws SQLException {
        pstmt.setObject(1, nuevoAtributo);
        pstmt.setInt(2, empleado.getIdPersona());
    }
}
