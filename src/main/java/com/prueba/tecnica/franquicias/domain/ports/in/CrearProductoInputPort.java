package com.prueba.tecnica.franquicias.domain.ports.in;

import com.prueba.tecnica.franquicias.domain.model.Producto;

public interface CrearProductoInputPort {
	
	Producto guardar(Producto producto);
}
