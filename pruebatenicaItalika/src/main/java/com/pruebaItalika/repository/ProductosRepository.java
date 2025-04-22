package com.pruebaItalika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebaItalika.entity.Productos;

import jakarta.transaction.Transactional;
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
	


	    // Llamada al SP para obtener todos los productos
	    @Transactional
	    @Procedure(procedureName = "SP_OBTENER_LISTA_DE_PRODUCTOS")
	    List<Productos> spObtenerProductos();

	    // Llamada al SP para obtener un producto por ID
	    @Transactional
	    @Procedure(procedureName = "SP_OBTENER_PROD_X_ID")
	    Productos spObtenerPorId(@Param("ID_PRODUCTO") Long id);

	    // Llamada al SP para insertar un producto
	    @Transactional
	    @Procedure(procedureName = "SP_INSERTAR_PRODUCTOS")
	    void spInsertarProducto(
	        @Param("NOMBRE_PRODUCTO") String nombre,
	        @Param("DESCRIPCION") String descripcion,
	        @Param("PRECIO") Float precio,
	        @Param("CANTIDAD") Integer cantidad,
	        @Param("ESTADO") Integer estado
	    );

	    // Llamada al SP para actualizar un producto
	    @Transactional
	    @Procedure(procedureName = "SP_ACTUALIZAR_PRODUCTO")
	    void spActualizarProducto(
	        @Param("ID_PRODUCTO") Long id,
	        @Param("NOMBRE_PRODUCTO") String nombre,
	        @Param("DESCRIPCION") String descripcion,
	        @Param("PRECIO") Float precio,
	        @Param("CANTIDAD") Integer cantidad,
	        @Param("ESTADO") Integer estado
	    );

	    // Llamada al SP para eliminar un producto
	    @Transactional
	    @Procedure(procedureName = "SP_ELIMINAR_PRODUCTO_X_ID")
	    void spEliminarProducto(@Param("ID_PRODUCTO") Long id);
	}
