package com.prueba.tecnica.franquicias.infrastructure.rest.dto;

public class ProductoConMasStockDTO {

	private String nombreSucursal;
	private String nombreProducto;
	private int stock;

	public ProductoConMasStockDTO() {

	}

	public ProductoConMasStockDTO(String nombreSucursal, String nombreProducto, int stock) {
		this.nombreSucursal = nombreSucursal;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
