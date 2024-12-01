/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ada.prueba.modelo.repositoriosDao;

import com.ada.prueba.modelo.entidades.Producto;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Clase de pruebas unitarias para el repositorio
 * @author Marco Caballero
 * @version 1.0
 */

@DataJpaTest
public class ProductoDaoTest {
    
    //Dependencias usadas
    @Autowired
    private ProductoDao productoDao;
        
    @Autowired
    private TestEntityManager testEntityManager;
      
    /**
     * Metodo que se ejecuta antes de todos las pruebas unitarias - persistencia a la bd
     */    
    @BeforeEach
    public void setUp() {
        
        long stock=2;
        double precio=100;
        
        Producto producto = new Producto();
        producto.setNombre("Pepsi");
        producto.setDescripcion("Bebida");
        producto.setPrecio(precio);
        producto.setStock(stock);
        
        //Persistimos
        testEntityManager.persist(producto);
        
        
    }
    
    /**
     * Metodo para comprobar la busqueda por id de un producto
     */
    @Test
    public void buscarProductoPorId() {
        
        long id = 1;
        Optional<Producto> producto  = productoDao.findById(id);
        System.out.println("Inicio de Resultado");
        System.out.println("El id es: " + producto.get().getId());
        Assertions.assertEquals(id, producto.get().getId());
        
    }
    
}
