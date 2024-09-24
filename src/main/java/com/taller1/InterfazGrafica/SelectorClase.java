package com.taller1.InterfazGrafica;

import com.taller1.Config.GestorDatos;
import com.taller1.Config.GestorDatosFactory;
import com.taller1.Modelo.Cargo;
import com.taller1.Modelo.Departamento;
import com.taller1.Modelo.Direccion;
import com.taller1.Modelo.Empleado;
import com.taller1.Modelo.Estudiante;
import com.taller1.Modelo.Municipio;
import com.taller1.Modelo.Pais;
import com.taller1.Modelo.Persona;
import com.taller1.Modelo.Cargo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorClase extends JFrame {

    private String accion;
    private String tipoAlmacenamiento;

    public SelectorClase(String accion, String tipoAlmacenamiento, Menu menu) {
        this.accion = accion;
        this.tipoAlmacenamiento = tipoAlmacenamiento;
        setTitle("Clases");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        JLabel clasesLabel = new JLabel("¿Con qué clase quieres trabajar?", SwingConstants.CENTER);
        add(clasesLabel);

        JButton botonCargo = new JButton("Cargo");
        botonCargo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Cargo", menu);
            }
        });
        add(botonCargo);

        JButton botonDepartamento = new JButton("Departamento");
        botonDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Departamento", menu);
            }
        });
        add(botonDepartamento);

        JButton botonDireccion = new JButton("Direccion");
        botonDireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Direccion", menu);
            }
        });
        add(botonDireccion);

        JButton botonEmpleado = new JButton("Empleado");
        botonEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Empleado", menu);
            }
        });
        add(botonEmpleado);

        JButton botonEstudiante = new JButton("Estudiante");
        botonEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Estudiante", menu);
            }
        });
        add(botonEstudiante);

        JButton botonMunicipio = new JButton("Municipio");
        botonMunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Municipio", menu);
            }
        });
        add(botonMunicipio);

        JButton botonPais = new JButton("Pais");
        botonPais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Pais", menu);
            }
        });
        add(botonPais);

        JButton botonPersona = new JButton("Persona");
        botonPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarAccion("Persona", menu);
            }
        });
        add(botonPersona);

        setVisible(true);
    }

    private void ejecutarAccion(String clase, Menu menu) {

        GestorDatos<?> gestorDatos = null;
        
        switch (clase) {
            case "Cargo":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Cargo.class);
                break;
            case "Departamento":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Departamento.class);
                break;
            case "Direccion":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Direccion.class);
                break;
            case "Empleado":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Empleado.class);
                break;
            case "Estudiante":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Estudiante.class);
                break;
            case "Municipio":
                gestorDatos = GestorDatosFactory.crearGestorDatos(tipoAlmacenamiento, clase + tipoAlmacenamiento, Municipio.class);
                break;
            case "Pais":
                break;
            case "Persona":
                break;
            default:
                JOptionPane.showMessageDialog(this, "Clase no soportada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

            
        try {
            switch (accion) {
                case "Crear":
                    gestorDatos.guardar(null);
                    break;
                case "Leer":
                    gestorDatos.leer(1);
                    break;
                case "Actualizar":
                    gestorDatos.actualizar(null);
                    break;
                case "Borrar":
                    gestorDatos.eliminar(1);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Acción no soportada.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            JOptionPane.showMessageDialog(this, "Operación " + accion + " realizada con éxito en " + clase + "!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la operación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        menu.setVisible(true);
        dispose(); 
    }
}
