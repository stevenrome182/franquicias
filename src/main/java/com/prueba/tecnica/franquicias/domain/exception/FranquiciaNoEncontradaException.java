package com.prueba.tecnica.franquicias.domain.exception;

public class FranquiciaNoEncontradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FranquiciaNoEncontradaException() {
		super("Franquicia no encontrada");
	}

	public FranquiciaNoEncontradaException(Long id) {
		super("Franquicia no encontrada con ID: " + id);
	}

	public FranquiciaNoEncontradaException(String nombre) {
		super("Franquicia no encontrada con nombre: " + nombre);
	}

}
