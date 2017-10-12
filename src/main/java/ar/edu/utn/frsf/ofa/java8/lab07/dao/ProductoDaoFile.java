/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.dao;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import ar.edu.utn.frsf.ofa.java8.lab07.util.FileManager;
import ar.edu.utn.frsf.ofa.java8.lab07.util.Formateable;

/**
 *
 * @author mdominguez
 */
public class ProductoDaoFile implements ProductoDao {

    private FileManager fileManager;
    
    public ProductoDaoFile(){
        fileManager = new FileManager("productos.csv");
    }
    
    @Override
    public Producto crear(Producto p) {
        fileManager.insertarLineaCSV(p);
        return p;
    }

    @Override
    public Producto actualizar(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarPorId(Integer id) {
        String[] data = fileManager.retornarLineaCSV(id);
        Producto buscado = new Producto();
        buscado.loadFromCsvRow(data);
        return buscado;
    }

    @Override
    public Producto borrar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
