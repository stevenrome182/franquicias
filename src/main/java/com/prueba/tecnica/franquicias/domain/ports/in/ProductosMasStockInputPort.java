package com.prueba.tecnica.franquicias.domain.ports.in;

import java.util.List;

import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoConMasStockDTO;

public interface ProductosMasStockInputPort {

	List<ProductoConMasStockDTO> productosMasStock(Long franquiciaId);
	
}
