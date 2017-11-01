/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.modelo;

import ar.edu.utn.frsf.ofa.java8.lab07.util.Formateable;
import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public class Producto implements Formateable{

    private static Integer _GENERADOR_ID=1;
    
    private Integer id;
    private String descripcion;
    private Integer stock;
    private Double precio;

    public Producto() {
      //  this.id = _GENERADOR_ID++;
    }

    public Producto(Integer id, String descripcion, Integer stock, Double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }
    
    public Producto(String descripcion, Integer stock, Double precio) {
        this(null,descripcion,stock,precio);
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

@Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio + '}';
    }

    @Override
    public String asCvsRow() {
        return this.id+","+this.descripcion+","+this.precio+","+this.stock+System.getProperty("line.separator");
    }

    @Override
    public void loadFromCsvRow(String[] row) {
        this.id = Integer.parseInt(row[0]);
        this.descripcion = row[1];
        this.precio = Double.parseDouble(row[2]);        
        this.stock = Integer.parseInt(row[3]);
    }

    
    
}
