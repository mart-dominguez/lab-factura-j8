/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.dao;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdominguez
 */
public class ProductoDaoFileTest {
    
    ProductoDao productoDao;

    
    @Before
    public void setUp() {
        productoDao = new ProductoDaoSql();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class ProductoDaoFile.
     */
    @Test
    public void testCrear() {
        Producto prd1 = new Producto("producto 1", 100, 99.90);
        Producto resultado = productoDao.crear(prd1);
        assertEquals(resultado, prd1);
    }

    

    /**
     * Test of buscarPorId method, of class ProductoDaoFile.
     */
    @Test
    public void testBuscarPorId() {
        Producto prd2 = new Producto("producto 2", 100, 99.90);
        Producto resultado = productoDao.crear(prd2);
        assertEquals(resultado.getDescripcion(), prd2.getDescripcion());
        assertEquals(resultado.getPrecio(), prd2.getPrecio());
        assertEquals(resultado.getStock(), prd2.getStock());
        Producto resultado2 = productoDao.buscarPorId(resultado.getId());
        assertEquals(resultado2, resultado);
    }

    
}
