package com.taller1.Modelo;


import java.io.Serializable;



public class Empleado extends Persona implements Serializable {
    private Cargo cargoEmpleado;
    private Double salarioEmpleado;
    private  static  final  long serialVersionUID = 1L;


    public Empleado(int idPersona, String nombresPersona, String apellidosPersona, Direccion direccion, Cargo cargoEmpleado, Double salarioEmpleado) {
        super(idPersona, nombresPersona, apellidosPersona, direccion);
        this.cargoEmpleado = cargoEmpleado;
        this.salarioEmpleado = salarioEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado [id=" + getIdPersona() + ", nombres=" + getNombrePersona() + ", apellidos=" + getApellidosPersona() +
               ", direccion=" + getDireccionPersona() + ", cargo=" + cargoEmpleado + ", salario=" + salarioEmpleado + "]";
    }

    public Cargo getCargoEmpleado() {
        return cargoEmpleado;
    }

    public Double getSalarioEmpleado() {
        return salarioEmpleado;
    }
    
    
}