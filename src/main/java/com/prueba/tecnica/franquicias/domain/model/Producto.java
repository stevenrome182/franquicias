package com.prueba.tecnica.franquicias.domain.model;

import com.prueba.tecnica.franquicias.domain.exception.StockNegativoException;

public class Producto {

	private Long id;
	private String nombre;
	private int stock;
	private Sucursal sucursal;

	public Producto() {
	}

	public Producto(String nombre, int stock, Sucursal sucursal) {
		this.nombre = nombre;
		this.stock = stock;
		this.sucursal = sucursal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public void establecerStock(int nuevoStock) {
		if (nuevoStock < 0) {
			throw new StockNegativoException("El stock no puede ser negativo");
		}
		this.stock = nuevoStock;
	}

}