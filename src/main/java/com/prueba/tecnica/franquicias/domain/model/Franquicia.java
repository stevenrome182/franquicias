package com.prueba.tecnica.franquicias.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Franquicia {

	private Long id;
	private String nombre;

	public Franquicia(String nombre) {
		this.nombre = nombre;
	}

}
