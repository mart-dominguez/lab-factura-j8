/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.dao;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface ProductoDao {
    
    public Producto crear(Producto p);
    public Producto actualizar(Producto p);
    public Producto buscarPorId(Integer id);
    public Producto borrar(Integer id);
    public List<Producto> listarTodos();
    
}
