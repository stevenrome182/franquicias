package com.prueba.tecnica.franquicias.domain.ports.out;

import java.util.Optional;

import com.prueba.tecnica.franquicias.domain.model.Producto;

public interface ProductoRepositoryPort {

	Producto guardar(Producto producto);

	Producto actualizar(Producto producto);

	void eliminar(Long id);

	Optional<Producto> buscarPorId(Long id);

	Producto productoMasStock(Long sucursalId);

}
