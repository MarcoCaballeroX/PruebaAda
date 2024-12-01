/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ada.prueba.servicios;

import com.ada.prueba.modelo.entidades.Producto;
import java.util.List;

/**
 * Interface que maneja los servicios de Producto
 * @author Marco Caballero
 * @version 1.0
 */
public interface ProductoServicio {

    /**
     * Metodo para obtener la lista de productos
     * @return List tipo Producto - lista de productos.
     */
    public List<Producto> obtenerListaProductos();

    /**
     * Metodo para persistir productos en la base de datos
     * @param producto  parametro tipo entidad
     */
    public void persistirProducto(Producto producto);

    /**
     * Metodo para eliminar producto
     * @param producto parametro tipo entidad
     */
    public void eliminarProducto(Producto producto);

    /**
     * Metodo para buscar un producto
     * @param producto parametro tipo entidad
     * @return Producto retorna una entidad producto
     */
    public Producto buscarProducto(Producto producto);

}
