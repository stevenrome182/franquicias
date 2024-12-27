package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.exception.FranquiciaNoEncontradaException;
import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreFranquiciaInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.FranquiciaRepositoryPort;

@Component
public class ActualizarNombreFranquiciaUseCase implements ActualizarNombreFranquiciaInputPort {

	private final FranquiciaRepositoryPort franquiciaRepositoryPort;

	public ActualizarNombreFranquiciaUseCase(FranquiciaRepositoryPort franquiciaRepositoryPort) {
		this.franquiciaRepositoryPort = franquiciaRepositoryPort;
	}

	@Override
	public void actualizarNombre(Long id, String nombre) {
		Franquicia franquicia = franquiciaRepositoryPort.obtenerFranquiciaById(id)
				.orElseThrow(() -> new FranquiciaNoEncontradaException(id));
		franquicia.setNombre(nombre);
		franquiciaRepositoryPort.guardar(franquicia);
	}

}
