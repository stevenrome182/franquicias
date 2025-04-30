package com.prueba.tecnica.franquicias.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDTO {

	private String nombre;
	private int stock;
	private Long sucursal;

}
