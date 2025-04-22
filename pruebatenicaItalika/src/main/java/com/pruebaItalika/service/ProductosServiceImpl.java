package com.pruebaItalika.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaItalika.dto.ProductosDTO;
import com.pruebaItalika.entity.Productos;
import com.pruebaItalika.repository.ProductosRepository;

import jakarta.transaction.Transactional;

@Service

public class ProductosServiceImpl implements ProductoService{
	
    @Autowired
    ProductosRepository productosRepository;
    
    @Override
    @Transactional
    public List<ProductosDTO> obtenerProductos() {
        List<Productos> productos = productosRepository.spObtenerProductos();
        List<ProductosDTO> productosDTOList = new ArrayList<>();

        for (Productos producto : productos) {
            ProductosDTO dto = new ProductosDTO();
            dto.setId(producto.getId());
            dto.setNombreP(producto.getNombreP());
            dto.setDescripcion(producto.getDescripcion());
            dto.setPrecio(producto.getPrecio());
            dto.setCantidad(producto.getCantidad());
            dto.setEstado(producto.getEstado());
            productosDTOList.add(dto);
        }

        return productosDTOList;
    }
    
    @Override
    @Transactional
    public ProductosDTO obtenerPorId(Long id) {
        Productos producto = productosRepository.spObtenerPorId(id);

        if (producto != null) {
            ProductosDTO dto = new ProductosDTO();
            dto.setId(producto.getId());
            dto.setNombreP(producto.getNombreP());
            dto.setDescripcion(producto.getDescripcion());
            dto.setPrecio(producto.getPrecio());
            dto.setCantidad(producto.getCantidad());
            dto.setEstado(producto.getEstado());
            return dto;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void insertarProducto(String nombre, String descripcion, Float precio, Integer cantidad, Integer estado) {
        productosRepository.spInsertarProducto(nombre, descripcion, precio, cantidad, estado);
    }

    @Override
    @Transactional
    public void actualizarProducto(Long id, String nombre, String descripcion, Float precio, Integer cantidad,
            Integer estado) {
    	
    	 Productos producto = productosRepository.findById(id)
    	            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    	    
    	
    	    if (producto.getEstado() == 1) {
    	        throw new IllegalStateException("No se puede actualizar el producto porque está bloqueado");
    	    }
        productosRepository.spActualizarProducto(id, nombre, descripcion, precio, cantidad, estado);
    }

    @Override
    @Transactional
    public void eliminarProducto(Long id) {
        productosRepository.spEliminarProducto(id);
    }
	
	

}
