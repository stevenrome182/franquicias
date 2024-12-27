package com.prueba.tecnica.franquicias.domain.model;

public class Franquicia {

	private Long id;
	private String nombre;

	public Franquicia() {

	}

	public Franquicia(String nombre) {
		this.nombre = nombre;
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

}
