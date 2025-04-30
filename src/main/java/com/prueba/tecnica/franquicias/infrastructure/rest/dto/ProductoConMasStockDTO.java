package com.prueba.tecnica.franquicias.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoConMasStockDTO {

	private String nombreSucursal;
	private String nombreProducto;
	private int stock;

}
