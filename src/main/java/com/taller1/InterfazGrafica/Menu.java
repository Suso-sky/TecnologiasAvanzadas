package com.taller1.InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Gestion de Datos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel bienvenidaTexto = new JLabel("Bienvenido a la aplicación de gestión de datos", SwingConstants.CENTER);
        add(bienvenidaTexto, BorderLayout.NORTH);

        JButton botonInicio = new JButton("Comenzar");
        botonInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorMetodoDatos();
            }
        });
        add(botonInicio, BorderLayout.CENTER);

        setVisible(true);
    }

    private void abrirSelectorMetodoDatos() {
        new SelectorMetodoDatos(this);
        setVisible(false);
    }
}
