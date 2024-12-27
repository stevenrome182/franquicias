package com.prueba.tecnica.franquicias.domain.model;

public class Sucursal {

	private Long id;
	private String nombre;
	private Franquicia franquicia;

	public Sucursal() {

	}

	public Sucursal(String nombre, Franquicia franquicia) {
		this.nombre = nombre;
		this.franquicia = franquicia;
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

	public Franquicia getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}

}
