/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ada.prueba.servicios;

import com.ada.prueba.modelo.entidades.Producto;
import com.ada.prueba.modelo.repositoriosDao.ProductoDao;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Clase de pruebas unitarias para el servicio
 * @author Marco Caballero
 * @version 1.0
 */

@SpringBootTest
public class ProductoServicioTest {
    
    @Autowired
    private ProductoServicio productoServicio;
    
    @MockBean
    private ProductoDao productoDao;
    
    /**
     * Metodo que se ejecuta antes de todos las pruebas unitarias - Simulacion de extraccion de datos de una bd
     */
    @BeforeEach
    public void setUp() {
        
        long stock=2;
        double precio=100;
        
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Pepsi");
        producto.setDescripcion("Bebida");
        producto.setPrecio(precio);
        producto.setStock(stock);
        
        Mockito.when(productoDao.findById(1L)).thenReturn(Optional.of(producto));
        
    }
        
    /**
     * Metodo para comprobar la busqueda por id de un producto
     */
    @Test
    public void testBuscarProducto() {
        long id = 1;
        Optional<Producto> producto  = productoDao.findById(id);
        Producto productoService  = productoServicio.buscarProducto(producto.get());
        Assertions.assertEquals(id, productoService.getId());

    }

   
    
}
