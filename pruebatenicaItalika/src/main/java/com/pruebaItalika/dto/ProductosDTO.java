package com.pruebaItalika.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProductosDTO {
	
	private Long id;  

    @NotNull(message = "El campo debe tener nombre de producto")
    private String nombreP;

    @NotNull(message = "El producto debe tener una descripcion")
    private String descripcion;

    @NotNull(message = "El producto debe tener un precio")
    @Min(value = 0, message = "No puedes tener el precio a menos de 0. No puedes deberte a ti mismo")
    private Float precio;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 0, message = "La cantidad no puede ser menor a 0. Significa que no tienes productos en existencia")
    private Integer cantidad;

    @NotNull(message = "El estado es 1 (Bloqueado) o 2 (NoBloqueado)")
    @Min(value = 1, message = "El estado debe ser 1 o 2")
    @Max(value = 2, message = "El estado solo puede ser 1 o 2")
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
