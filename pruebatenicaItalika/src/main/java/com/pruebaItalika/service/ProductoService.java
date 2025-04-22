package com.pruebaItalika.service;

import java.util.List;

import com.pruebaItalika.dto.ProductosDTO;

public interface ProductoService {
	
	
	List<ProductosDTO> obtenerProductos();

	ProductosDTO obtenerPorId(Long id);
	
	public void insertarProducto(String nombre, String descripcion, Float precio, Integer cantidad, Integer estado);

   public void actualizarProducto(Long id, String nombre, String descripcion, Float precio, Integer cantidad, Integer estado);

    public void eliminarProducto(Long id);

}
