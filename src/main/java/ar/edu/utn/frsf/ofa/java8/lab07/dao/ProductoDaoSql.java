/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.dao;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;

/**
 *
 * @author martdominguez
 */
public class ProductoDaoSql implements ProductoDao{

    @Override
    public Producto crear(Producto p) {
        
    }

    @Override
    public Producto actualizar(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto borrar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
