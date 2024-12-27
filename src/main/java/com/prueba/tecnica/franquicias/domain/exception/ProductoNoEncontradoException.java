package com.prueba.tecnica.franquicias.domain.exception;

public class ProductoNoEncontradoException extends RuntimeException {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNoEncontradoException(Long id) {
        super("Producto no encontrado con ID: " + id);
    }
	
	public ProductoNoEncontradoException() {
        super("El producto debe tener una sucursal asignada.");
    }
}
