package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.ports.in.EliminarProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EliminarProductoUseCase implements EliminarProductoInputPort {

	private final ProductoRepositoryPort productoRepository;

	@Override
	public void eliminar(Long id) {
		productoRepository.buscarPorId(id).orElseThrow(() -> new ProductoNoEncontradoException(id));
		productoRepository.eliminar(id);
	}

}
