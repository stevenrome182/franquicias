package com.prueba.tecnica.franquicias.domain.exception;

public class SucursalNoEncontradaException extends RuntimeException {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SucursalNoEncontradaException(Long id) {
        super("Sucursal no encontrada con ID: " + id);
    }
}
