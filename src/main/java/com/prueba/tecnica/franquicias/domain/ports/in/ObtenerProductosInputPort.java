package com.prueba.tecnica.franquicias.domain.ports.in;

import java.util.List;

import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoDTO;

public interface ObtenerProductosInputPort {
	
	List<ProductoDTO> obtenerProductos();

}
