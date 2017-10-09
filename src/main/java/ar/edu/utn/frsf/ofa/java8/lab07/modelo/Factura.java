/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mdominguez
 */
public class Factura {
        private static Integer _GENERADOR_ID=1;

    
    private Integer id;
    private Vendedor vendedor;
    private List<DetalleFactura> detalle;

    public Factura() {
        this.id = _GENERADOR_ID++;
        this.detalle = new ArrayList<>();
    }

    public Factura(Integer id, Vendedor vendedor) {
        this.id = id;
        this.vendedor = vendedor;
        this.detalle = new ArrayList<>();
    }

    public Factura(Vendedor vendedor) {
        this(_GENERADOR_ID++,vendedor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void add(DetalleFactura df){
        this.detalle.add(df);
    }
    
    public void remove(DetalleFactura df){
        this.detalle.remove(df);
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Factura other = (Factura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
