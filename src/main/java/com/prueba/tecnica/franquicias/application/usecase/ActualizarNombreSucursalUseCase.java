package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.SucursalNoEncontradaException;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreSucursalInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActualizarNombreSucursalUseCase implements ActualizarNombreSucursalInputPort {

	private final SucursalRepositoryPort sucursalRepositoryPort;

	@Override
	public void actualizarNombre(Long id, String nombre) {
		Sucursal sucursal = sucursalRepositoryPort.obtenrSucursalById(id)
				.orElseThrow(() -> new SucursalNoEncontradaException(id));
		sucursal.setNombre(nombre);
		sucursalRepositoryPort.guardar(sucursal);
	}

}
