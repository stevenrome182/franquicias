package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActualizarNombreProductoUseCase implements ActualizarNombreProductoInputPort {

	private final ProductoRepositoryPort productoRepositoryPort;

	@Override
	public void actualizarNombre(Long id, String nombre) {
		Producto producto = productoRepositoryPort.buscarPorId(id)
				.orElseThrow(() -> new ProductoNoEncontradoException(id));
		producto.setNombre(nombre);
		productoRepositoryPort.guardar(producto);
	}

}
