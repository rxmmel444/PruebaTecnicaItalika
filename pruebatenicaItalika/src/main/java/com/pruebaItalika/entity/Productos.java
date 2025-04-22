package com.pruebaItalika.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTOS_ITALIKA")
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Long id;
	
	@NotNull(message = "El campo debe tener nombre de producto")
	@Column(name = "NOMBRE_PRODUCTO") 
	private String nombreP;
	
	@NotNull(message = "El producto debe tener una descripcion")
	@Column(name = "DESCRIPCION") 
	private String descripcion;
	
	@NotNull(message = "el producto debe tener un precio")
	@Min(value = 0,message = "no puedes tener el precio a menos 0 no puedes deberte a ti mismo")
	@Column(name = "PRECIO") 
	private Float precio;
	
	@NotNull(message = "la cantidad no puede ser nula")
	@Min(value = 0, message = "la cantidad no puede ser menor a O significa que no tienes productos en existencia")
	@Column(name = "CANTIDAD") 
	private Integer cantidad;


	@NotNull(message = "El estado es 1(Bloqueado) 2 (NoBloqueado)")
	@Min(value = 1, message = "El estado debe ser 1 o 2")
	@Max(value = 2, message = "El estado solo puede ser 1 o 2")
	@Column(name = "ESTADO") 
	private Integer estado;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreP() {
		return nombreP;
	}


	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	

}
