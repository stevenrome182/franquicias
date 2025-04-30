package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarStockInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActualizarStockUseCase implements ActualizarStockInputPort {

	private final ProductoRepositoryPort productoRepository;

	@Override
	public void actualizarStock(Long id, int cantidad) {
		Producto producto = productoRepository.buscarPorId(id).orElseThrow(() -> new ProductoNoEncontradoException(id));
		producto.establecerStock(cantidad);
		productoRepository.guardar(producto);
	}

}
