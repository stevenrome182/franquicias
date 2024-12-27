package com.prueba.tecnica.franquicias.infrastructure.rest.dto;

public class SucursalDTO {

	private String nombre;
	private Long franquicia;

	public SucursalDTO(String nombre, Long franquicia) {
		this.nombre = nombre;
		this.franquicia = franquicia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Long franquicia) {
		this.franquicia = franquicia;
	}

}
