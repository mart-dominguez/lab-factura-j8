/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.gui.controller;

import ar.edu.utn.frsf.ofa.java8.lab07.gui.view.ProductoPanel;
import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mdominguez
 */
public class ProductoController {
    private JFrame ventana;
    ProductoPanel productoView;
    public ProductoController(JFrame ventana){
        this.ventana = ventana;
        productoView = new ProductoPanel();
    }
    
    public void mostrarProductos(){
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                JPanel panelProducto = productoView.build();
                ventana.getContentPane().removeAll();
                ventana.getContentPane().add(panelProducto);
                ventana.pack(); // cambia tamanños
                //ventana.revalidate(); // solo cambia dibujo9
             }
         });

    }
    
    public Producto getProducto(Integer id){
        return new Producto("aaaa", 100, 99.63);
    }
}
