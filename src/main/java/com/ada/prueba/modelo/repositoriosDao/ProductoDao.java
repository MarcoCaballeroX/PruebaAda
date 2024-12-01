/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ada.prueba.modelo.repositoriosDao;

import com.ada.prueba.modelo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase Respositorio DAO de Producto 
 * @author Marco Caballero
 * @version 1.0 
 */
@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

}
