/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.gui.view;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mdominguez
 */
public class ProductoPanel {
    private JPanel panel;
    private JLabel lblDescripcion;
    private JLabel lblStock;
    private JLabel lblPrecio;

    private JTextField txtDescripcion;
    private JTextField txtStock;
    private JTextField txtPrecio;
    
    private JButton btnAgregar;
    private JButton btnCancelar;
    
    private Producto productoActual;
    
    public JPanel build(){
        
        GridLayout grid= new GridLayout(4, 2);
        JPanel panel = new JPanel(grid);
        
        lblDescripcion = new JLabel("Nombre del producto:");
        lblStock = new JLabel("Stock:");
        lblPrecio = new JLabel("Precio:");

        txtDescripcion = new JTextField(50);
        txtStock = new JTextField(5);        
        txtPrecio = new JTextField(5);

        if(productoActual!=null){
            txtDescripcion.setText(productoActual.getDescripcion());
            txtStock.setText(productoActual.getStock().toString());
            txtPrecio.setText(productoActual.getPrecio().toString());
        }
        
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
        
        btnAgregar.addActionListener(l -> System.out.println("HOLA Agregar"));
        btnCancelar.addActionListener(l -> System.out.println("HOLA Cancelar"));
        
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        
        panel.add(lblStock);
        panel.add(txtStock);

        panel.add(lblPrecio);
        panel.add(txtPrecio);

        panel.add(btnAgregar);
        panel.add(btnCancelar);

        return panel;
    }

    public Producto getProductoActual() {
        return productoActual;
    }

    public void setProductoActual(Producto productoActual) {
        this.productoActual = productoActual;
    }
    
    
}
