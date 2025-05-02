package com.prueba.tecnica.franquicias.application.usecase;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.FranquiciaNoEncontradaException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.ProductosMasStockInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoConMasStockDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductosMasStockUseCase implements ProductosMasStockInputPort {

	private final ProductoRepositoryPort productoRepository;
	private final SucursalRepositoryPort sucursalRepositoryPort;

	@Override
	public List<ProductoConMasStockDTO> productosMasStock(Long franquiciaId) {
		List<Sucursal> sucursales = sucursalRepositoryPort.obtenerSucursalesByFranquicia(franquiciaId);
		if (sucursales.isEmpty()) {
			throw new FranquiciaNoEncontradaException("Franquicia no encontrada con ID: " + franquiciaId);
		}
		return sucursales.stream().map(sucursal -> {
			Producto producto = productoRepository.productoMasStock(sucursal.getId());
			if (producto != null) {
				return new ProductoConMasStockDTO(sucursal.getNombre(), producto.getNombre(), producto.getStock());
			}
			return null;
		}).filter(Objects::nonNull).toList();
	}

}
