
package com.taller1.InterfazGrafica;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorAccion extends JFrame {
    private String TipoAlmacenamiento;

    public SelectorAccion(String storageType, Menu menu) {
        this.TipoAlmacenamiento = storageType;
        setTitle("CRUD");
        setSize(300, 200);
        setLayout(new GridLayout(5, 1));

        JLabel accionLabel = new JLabel("¿Qué deseas hacer?", SwingConstants.CENTER);
        add(accionLabel);

        JButton botonCrear = new JButton("Crear");
        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorClase("Crear", menu);
            }
        });
        add(botonCrear);

        JButton botonLeer = new JButton("Leer");
        botonLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorClase("Leer", menu);
            }
        });
        add(botonLeer);

        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorClase("Actualizar", menu);
            }
        });
        add(botonActualizar);

        JButton botonEliminar = new JButton("Borrar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorClase("Borrar", menu);
            }
        });
        add(botonEliminar);

        setVisible(true);
    }

    // Abre la ventana para seleccionar la clase
    private void abrirSelectorClase(String action, Menu mainFrame) {
        new SelectorClase(action, TipoAlmacenamiento, mainFrame); 
        setVisible(false); 
    }
}
