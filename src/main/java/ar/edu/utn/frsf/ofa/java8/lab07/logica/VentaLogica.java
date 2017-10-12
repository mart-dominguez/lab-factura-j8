/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.java8.lab07.logica;

import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Factura;
import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Producto;
import ar.edu.utn.frsf.ofa.java8.lab07.modelo.Vendedor;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface VentaLogica {
    public Factura crearFactura(Integer idVendedor);
    public void facturarProducto(Integer idFactura,Integer idProducto,Integer cantidad);
    public List<Factura> facturasPorVendedor(Integer idVendedor);
    public Vendedor liderVentas();
    public Producto productoMasVendido();
    public Double ventaPromedio();
}
