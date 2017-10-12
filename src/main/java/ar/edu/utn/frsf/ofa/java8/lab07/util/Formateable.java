/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.util;

/**
 *
 * @author mdominguez
 */
public interface Formateable {
    /**
     * retorna una instancia de un objeto como una fila de archivos CVS
     * @return 
     */
    public String asCvsRow();
    
    public void loadFromCsvRow(String[] row);
}
