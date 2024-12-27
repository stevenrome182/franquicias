package com.prueba.tecnica.franquicias.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prueba.tecnica.franquicias.domain.exception.FranquiciaNoEncontradaException;
import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.exception.StockNegativoException;
import com.prueba.tecnica.franquicias.domain.exception.SucursalNoEncontradaException;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FranquiciaNoEncontradaException.class)
	public ResponseEntity<ErrorResponse> handleFranquiciaNoEncontrada(FranquiciaNoEncontradaException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SucursalNoEncontradaException.class)
	public ResponseEntity<ErrorResponse> handleSucursalNoEncontrada(SucursalNoEncontradaException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProductoNoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StockNegativoException.class)
	public ResponseEntity<ErrorResponse> handleStockNegativo(StockNegativoException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
