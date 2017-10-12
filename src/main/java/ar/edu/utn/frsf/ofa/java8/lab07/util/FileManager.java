/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public class FileManager {
    private String archivo;
    private String directorio;
    
    public FileManager(String archivo){
        this.directorio="db";
        this.archivo = archivo;
    }
    
    
    
    private File getFile(){
        File directorioDB = new File(directorio);
        File dataFile = new File(directorioDB, archivo);
        try {
            if(!directorioDB.exists()) directorioDB.mkdirs();
            if(!dataFile.exists()) dataFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFile;       
    }
    
    public void insertarLineaCSV(Formateable objeto){
        BufferedWriter salida =null;
        FileWriter fileWriter= null;
        try { 
            fileWriter = new FileWriter(getFile(),true);
            salida = new BufferedWriter(fileWriter);
            salida.write(objeto.asCvsRow());
            salida.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try { 
                if(salida!=null){
                    salida.close();
                }
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public String[] retornarLineaCSV(Integer id){
        String linea;
        String[] resultado;
        BufferedReader  entrada =null;
        FileReader fileReader= null;
        try { 
            fileReader = new FileReader(getFile());
            entrada = new BufferedReader(fileReader);
            while((linea = entrada.readLine())!=null){
                resultado = linea.split(",");
                if(Integer.parseInt(resultado[0])==id) return resultado;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try { 
                if(entrada!=null){
                    entrada.close();
                }
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        return null;
    }
}
