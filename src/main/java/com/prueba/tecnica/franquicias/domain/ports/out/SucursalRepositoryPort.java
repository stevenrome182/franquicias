package com.prueba.tecnica.franquicias.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.prueba.tecnica.franquicias.domain.model.Sucursal;

public interface SucursalRepositoryPort {

	Sucursal guardar(Sucursal sucursal);

	Sucursal actaulizar(Sucursal sucursal);

	Optional<Sucursal> obtenrSucursalById(Long id);

	List<Sucursal> obtenerSucursalesByFranquicia(Long id);

}
