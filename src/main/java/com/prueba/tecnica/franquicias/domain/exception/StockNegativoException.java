package com.prueba.tecnica.franquicias.domain.exception;

public class StockNegativoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockNegativoException(String mensaje) {
		super(mensaje);
	}
}