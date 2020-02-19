package com.dgpunam.UIMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntradaPrincipal {
    private JPanel mainPanel;
    private JButton cerrar;
    private JButton altaBoton;
    private JButton bajaBoton;
    private JButton ModificarBoton;
    private JButton chequeBoton;
    private JLabel bienvenue;


    public EntradaPrincipal() {
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cerrar) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EntradaPrincipal");
        frame.setContentPane(new EntradaPrincipal().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
