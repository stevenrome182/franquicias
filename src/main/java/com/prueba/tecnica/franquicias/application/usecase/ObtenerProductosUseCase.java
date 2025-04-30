package com.prueba.tecnica.franquicias.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.ports.in.ObtenerProductosInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObtenerProductosUseCase implements ObtenerProductosInputPort {

	private final ProductoRepositoryPort productoRepositoryPort;

	@Override
	public List<ProductoDTO> obtenerProductos() {
		final var productos = productoRepositoryPort.obtenerProductos();
		return productos.stream().map(
				producto -> new ProductoDTO(producto.getNombre(), producto.getStock(), producto.getSucursal().getId())
		).toList();
	}

}
