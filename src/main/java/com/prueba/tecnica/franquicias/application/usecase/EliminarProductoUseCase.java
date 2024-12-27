package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.ports.in.EliminarProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

@Component
public class EliminarProductoUseCase implements EliminarProductoInputPort {

	private final ProductoRepositoryPort productoRepository;

	public EliminarProductoUseCase(ProductoRepositoryPort productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public void eliminar(Long id) {
		productoRepository.eliminar(id);
	}

}
