/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ada.prueba.controladores;

import com.ada.prueba.Constantes.Vistas;
import com.ada.prueba.modelo.entidades.Producto;
import com.ada.prueba.modelo.modelosDto.ProductoDto;
import com.ada.prueba.servicios.ProductoServicio;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Clase Controlador que maneja las peticiones relacionadas con la gestion de Productos
 * @author Marco Caballero
 * @version 1.0
 */
@Controller
@Slf4j
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    /**
     * Metodo que redirecciona a la vista de inicio de la aplicacion 
     * @return String vista de inicio - index.html 
     */
    @GetMapping("/")
    public String renderVistaInicio() {
        return Vistas.VISTA_INICIO;
    }

    /**
     * Metodo que redirecciona al formulario de registro de productos
     * @param model parametro modelo
     * @return String vista formulario de registro y edicion de productos - formulario-producto.html
     */
    @GetMapping("/renderFormularioProducto")
    public String renderFormularioProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return Vistas.VISTA_FORMULARIO_PRODUCTO;
    }

    /**
     * Metodo que redirecciona a la interfaz de visualizacion de productos
     * @param model parametro modelo
     * @return String vista visualizacion de productos - visualizar-productos.html
     */
    @GetMapping("/renderVisualizarProductos")
    public String renderVisualizarProductos(Model model) {
        List<Producto> productos = this.productoServicio.obtenerListaProductos();
        // Mapeo de Entidad a un DTO 
        List<ProductoDto> listaProductos = productos.stream()
                .map(producto -> new ProductoDto(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toList());

        model.addAttribute("listaProductos", listaProductos);
        return Vistas.VISTA_VISUALIZAR_PRODUCTOS;
    }
    
    /**
     * Metodo que redirecciona al formulario de edicion de productos
     * @param producto parametro tipo entidad
     * @param model parametro modelo
     * @return String vista formulario de registro y edicion de productos - formulario-producto.html 
     */
    @GetMapping("/renderEditar/{id}")
    public String renderEditar(Producto producto, Model model) {
        producto = this.productoServicio.buscarProducto(producto);
        model.addAttribute("producto", producto);
        return Vistas.VISTA_FORMULARIO_PRODUCTO;
    }
    
    /**
     * Metodo para eliminar un producto
     * @param producto parametro tipo entidad
     * @param redirectAttributes parametro para mensajes
     * @return String vista de inicio - index.html
     */
    @GetMapping("/accionEliminar")
    public String accionEliminar(Producto producto, RedirectAttributes redirectAttributes) {
        this.productoServicio.eliminarProducto(producto);
        redirectAttributes.addFlashAttribute("mensaje", "Producto Eliminado");
        return "redirect:/";
    }
    
    /**
     * Metodo para persistir en la base de datos un producto
     * @param producto parametro entidad
     * @param redirectAttributes parametro para mensajes
     * @return String vista de inicio - index.html
     */
    @PostMapping("/accionPersistirProducto")
    public String accionPersistirProducto(Producto producto, RedirectAttributes redirectAttributes) {
        //Establecemos mensaje de registro o edicion
        redirectAttributes.addFlashAttribute("mensaje", "Producto Registrado");
        if (producto.getId() != null) {
            redirectAttributes.addFlashAttribute("mensaje", "Producto Editado");
        }

        this.productoServicio.persistirProducto(producto);

        return "redirect:/";
    }

}
