/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prueba.servicios;

import com.ada.prueba.modelo.entidades.Producto;
import com.ada.prueba.modelo.repositoriosDao.ProductoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase de implementacion de los servicios de producto
 * @author Marco Caballero
 * @version 1.0
 */
@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoDao productoDao;

    /**
     * Metodo para obtener la lista de productos
     * @return List tipo Producto 
     */
    @Override
    @Transactional(readOnly = true)
    public List<Producto> obtenerListaProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    /**
     * Metodo para registrar o editar un producto
     * @param producto parametro tipo entidad
     */
    @Override
    @Transactional
    public void persistirProducto(Producto producto) {
        productoDao.save(producto);
    }

    /**
     * Metodo para eliminar un producto
     * @param producto parametro tipo entidad
     */
    @Override
    @Transactional
    public void eliminarProducto(Producto producto) {
        productoDao.delete(producto);
    }

    /**
     * Metodo para buscar productos por id
     * @param producto parametro tipo entidad
     * @return Producto retorna una entidad
     */
    @Override
    @Transactional(readOnly = true)
    public Producto buscarProducto(Producto producto) {
        return productoDao.findById(producto.getId()).orElse(null);
    }

}
