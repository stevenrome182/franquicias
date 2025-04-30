package com.prueba.tecnica.franquicias.domain.model;

import com.prueba.tecnica.franquicias.domain.exception.StockNegativoException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producto {

	private Long id;
	private String nombre;
	private int stock;
	private Sucursal sucursal;

	public Producto(String nombre, int stock, Sucursal sucursal) {
		this.nombre = nombre;
		this.stock = stock;
		this.sucursal = sucursal;
	}

	public void establecerStock(int nuevoStock) {
		if (nuevoStock < 0) {
			throw new StockNegativoException("El stock no puede ser negativo");
		}
		this.stock = nuevoStock;
	}

}