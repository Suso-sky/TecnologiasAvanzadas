/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.taller1.InterfazGrafica;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorMetodoDatos extends JFrame {
    public SelectorMetodoDatos(Menu menu) {
        setTitle("Gestion de Datos");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        JLabel seleccionLabel = new JLabel("Tipo de almacenamiento:", SwingConstants.CENTER);
        add(seleccionLabel);

        // Opciones de almacenamiento
        JButton h2Button = new JButton("Base de datos H2");
        h2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorAccion("H2", menu);
            }
        });
        add(h2Button);

        JButton txtButton = new JButton("Archivo .txt");
        txtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorAccion(".txt", menu);
            }
        });
        add(txtButton);

        JButton binButton = new JButton("Archivo .bin");
        binButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSelectorAccion(".bin", menu);
            }
        });
        add(binButton);

        setVisible(true);
    }

    private void abrirSelectorAccion(String storageType, Menu menu) {
        new SelectorAccion(storageType, menu);
        setVisible(false); 
    }
}