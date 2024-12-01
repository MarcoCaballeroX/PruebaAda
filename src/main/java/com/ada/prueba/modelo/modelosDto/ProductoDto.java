/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prueba.modelo.modelosDto;

import lombok.Data;

/**
 * Clase DTO de Producto
 * @author Marco Caballero
 * @version 1.0
 */
@Data //Automáticamente genera varios métodos comunes set, get, constructor, etc
public class ProductoDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long stock;

    /**
     * Constructor con argumentos de la clase ProdcutoDto
     * @param id atributo de la clase
     * @param nombre atributo de la clase
     * @param descripcion atributo de la clase
     * @param precio atributo de la clase
     * @param stock atributo de la clase
     */
    public ProductoDto(Long id, String nombre, String descripcion, Double precio, Long stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

}
