package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.ProductoNoEncontradoException;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CrearProductoUseCase implements CrearProductoInputPort {

	private final ProductoRepositoryPort productoRepository;
	private final SucursalRepositoryPort sucursalRepositoryPort;

	@Override
	public Producto guardar(Producto producto) {
		if (producto.getSucursal() == null) {
			throw new ProductoNoEncontradoException();
		}
		Sucursal sucursal = sucursalRepositoryPort.obtenrSucursalById(producto.getSucursal().getId())
				.orElseThrow(() -> new ProductoNoEncontradoException(producto.getSucursal().getId()));
		producto.setSucursal(sucursal);
		return productoRepository.guardar(producto);
	}

}
