/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prueba.modelo.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase Entidad Producto
 * @author Marco Caballero
 * @version 1.0
 */
@Data //Automáticamente genera varios métodos comunes set, get, constructor, etc
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long stock;

}
