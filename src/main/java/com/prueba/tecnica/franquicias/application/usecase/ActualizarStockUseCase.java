package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarStockInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

@Component
public class ActualizarStockUseCase implements ActualizarStockInputPort {

	private final ProductoRepositoryPort productoRepository;

	public ActualizarStockUseCase(ProductoRepositoryPort productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public void actualizarStock(Long id, int cantidad) {
		Producto producto = productoRepository.buscarPorId(id).orElseThrow(() -> new ProductoNoEncontradoException(id));
		producto.establecerStock(cantidad);
		productoRepository.guardar(producto);
	}

}
