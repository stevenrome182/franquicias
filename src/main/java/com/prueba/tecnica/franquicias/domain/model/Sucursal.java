package com.prueba.tecnica.franquicias.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sucursal {

	private Long id;
	private String nombre;
	private Franquicia franquicia;

	public Sucursal(String nombre, Franquicia franquicia) {
		this.nombre = nombre;
		this.franquicia = franquicia;
	}

}
