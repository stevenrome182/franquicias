package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.FranquiciaNoEncontradaException;
import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearSucursalInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.FranquiciaRepositoryPort;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;

@Component
public class CrearSucursalUseCase implements CrearSucursalInputPort {

	private final SucursalRepositoryPort sucursalRepositoryPort;
	private final FranquiciaRepositoryPort franquiciaRepository;

	public CrearSucursalUseCase(SucursalRepositoryPort sucursalRepositoryPort,
			FranquiciaRepositoryPort franquiciaRepository) {
		this.sucursalRepositoryPort = sucursalRepositoryPort;
		this.franquiciaRepository = franquiciaRepository;
	}

	@Override
	public Sucursal guardar(Sucursal sucursal) {
		if (sucursal.getFranquicia() == null) {
			throw new FranquiciaNoEncontradaException();
		}
		Franquicia franquicia = franquiciaRepository.obtenerFranquiciaById(sucursal.getFranquicia().getId())
				.orElseThrow(() -> new FranquiciaNoEncontradaException(sucursal.getFranquicia().getId()));
		sucursal.setFranquicia(franquicia);
		return sucursalRepositoryPort.guardar(sucursal);
	}

}
