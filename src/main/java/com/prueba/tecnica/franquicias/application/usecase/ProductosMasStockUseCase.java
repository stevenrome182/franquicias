package com.prueba.tecnica.franquicias.application.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.ProductosMasStockInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoConMasStockDTO;

@Component
public class ProductosMasStockUseCase implements ProductosMasStockInputPort {

	private final ProductoRepositoryPort productoRepository;
	private final SucursalRepositoryPort sucursalRepositoryPort;

	public ProductosMasStockUseCase(ProductoRepositoryPort productoRepository,
			SucursalRepositoryPort sucursalRepositoryPort) {
		this.productoRepository = productoRepository;
		this.sucursalRepositoryPort = sucursalRepositoryPort;
	}

	@Override
	public List<ProductoConMasStockDTO> productosMasStock(Long franquiciaId) {
		List<Sucursal> sucursales = sucursalRepositoryPort.obtenerSucursalesByFranquicia(franquiciaId);
		List<ProductoConMasStockDTO> resultados = new ArrayList<>();
		for (Sucursal sucursal : sucursales) {
			Producto productoConMasStock = productoRepository.productoMasStock(sucursal.getId());
			if (productoConMasStock != null) {
				ProductoConMasStockDTO dto = new ProductoConMasStockDTO(sucursal.getNombre(),
						productoConMasStock.getNombre(), productoConMasStock.getStock());
				resultados.add(dto);
			}
		}
		return resultados;
	}

}
