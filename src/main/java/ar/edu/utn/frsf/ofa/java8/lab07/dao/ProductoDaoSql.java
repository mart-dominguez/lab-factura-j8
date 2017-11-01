/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.dao;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martdominguez
 */
public class ProductoDaoSql implements ProductoDao {

    private static final String _SQL_SELECT_BY_ID = "SELECT ID,DESCRIPCION,PRECIO,STOCK FROM TP_PRODUCTO WHERE ID = ?";
    private static final String _SQL_SELECT_ALL = "SELECT ID,DESCRIPCION,PRECIO,STOCK FROM TP_PRODUCTO ";

    private static final String _SQL_INSERT = "INSERT INTO TP_PRODUCTO (DESCRIPCION,PRECIO,STOCK) VALUES ( ?,?,?)";
    private static final String _SQL_UPDATE = "UPDATE TP_PRODUCTO (DESCRIPCION,PRECIO,STOCK) VALUES ( ?,?,?) WHERE ID= ?";
    private static final String _SQL_DELETE = "DELETE FROM TP_PRODUCTO WHERE ID = ?";
    
    @Override
    public Producto crear(Producto p) {
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement pstm = conn.prepareStatement(_SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, p.getDescripcion());
            pstm.setDouble(2, p.getPrecio());
            pstm.setInt(3, p.getStock());
            pstm.executeUpdate();
            int filasAfectadas = pstm.executeUpdate();

            // el ID unico lo genera la base de datos por lo tanto lo tenemos que recupear con el siguiente codigo
            // y luego asignarselo al producto
            if (filasAfectadas >= 0) {
                try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        
                        p.setId(generatedKeys.getInt(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    @Override
    public Producto actualizar(Producto p) {
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement pstm = conn.prepareStatement(_SQL_UPDATE)) {
            pstm.setString(1, p.getDescripcion());
            pstm.setDouble(2, p.getPrecio());
            pstm.setInt(3, p.getStock());
            pstm.setInt(4, p.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Producto buscarPorId(Integer id) {
        Connection conn = DBConnection.getInstance().getConnection();
        Producto p = null;
        try (PreparedStatement pstm = conn.prepareStatement(_SQL_SELECT_BY_ID)) {
            pstm.setInt(1, id);            
            try (ResultSet resultado= pstm.executeQuery()) {
                if (resultado.next()) {
                    p = new Producto();
                    p.setId(resultado.getInt(1));
                    p.setDescripcion(resultado.getString(2));
                    p.setPrecio(resultado.getDouble(3));
                    p.setStock(resultado.getInt(4));
                }
            } catch (SQLException ex) {
                    Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Producto borrar(Integer id) {
        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement pstm = conn.prepareStatement(_SQL_DELETE)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Producto> listarTodos() {
         Connection conn = DBConnection.getInstance().getConnection();
        List<Producto> lista = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(_SQL_SELECT_ALL)) {
            try (ResultSet resultado= pstm.executeQuery()) {
                while (resultado.next()) {
                    Producto p = new Producto();
                    p.setId(resultado.getInt(1));
                    p.setDescripcion(resultado.getString(2));
                    p.setPrecio(resultado.getDouble(3));
                    p.setStock(resultado.getInt(4));
                    lista.add(p);
                }
            } catch (SQLException ex) {
                    Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    
}
