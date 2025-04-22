package com.pruebaItalika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaItalika.dto.ProductosDTO;
import com.pruebaItalika.service.ProductosServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
	
    @Autowired
    private ProductosServiceImpl productoService; 

    
    @GetMapping
    public ResponseEntity<List<ProductosDTO>> obtenerProductos() {
        List<ProductosDTO> productos = productoService.obtenerProductos();

        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    


    @GetMapping("/{id}")
    public ResponseEntity<ProductosDTO> obtenerPorId(@PathVariable Long id) {
        ProductosDTO producto = productoService.obtenerPorId(id);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);  
    }


    @PostMapping
    public ResponseEntity<Void> insertarProducto(@RequestBody ProductosDTO productosDTO) {
        productoService.insertarProducto(productosDTO.getNombreP(), productosDTO.getDescripcion(),
                productosDTO.getPrecio(), productosDTO.getCantidad(), productosDTO.getEstado());
        return new ResponseEntity<>(HttpStatus.CREATED);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody ProductosDTO productosDTO) {
        try {
            productoService.actualizarProducto(id, 
                                               productosDTO.getNombreP(),
                                               productosDTO.getDescripcion(),
                                               productosDTO.getPrecio(),
                                               productosDTO.getCantidad(),
                                               productosDTO.getEstado());
            return ResponseEntity.ok("Producto actualizado exitosamente.");
        } catch (IllegalStateException ex) {
  
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }
    
  
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }
	
	

}
