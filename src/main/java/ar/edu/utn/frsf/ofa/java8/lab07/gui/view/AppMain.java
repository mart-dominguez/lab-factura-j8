/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.gui.view;

import ar.edu.utn.frsf.ofa.java8.lab07.gui.controller.ProductoController;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mdominguez
 */
public class AppMain {

    public static void crearGUI() {
        
        JFrame principal = new JFrame("Aplicacion productos");
        GridLayout grid= new GridLayout(2, 2);
        JPanel panel = new JPanel(grid);
        JButton btnProductos = new JButton("Productos");
        JButton btnVendedores = new JButton("Vendedores");
        JButton btnFacturas = new JButton("Facturar");
        JButton btnReportes = new JButton("Reportes");
        
        panel.add(btnProductos);
        panel.add(btnVendedores);
        panel.add(btnFacturas);
        panel.add(btnReportes);
        
        ProductoController prodController = new ProductoController(principal);
        btnProductos.addActionListener(l -> prodController.mostrarProductos());
        
       
       // principal.add(panel);
       principal.getContentPane().add(panel);
       // principal.setSize(800, 600);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.pack();
        principal.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearGUI();
            }
        });
    }
}
