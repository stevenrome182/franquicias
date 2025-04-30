package com.prueba.tecnica.franquicias.application.usecase;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearFranquiciaInputPort;
import com.prueba.tecnica.franquicias.domain.ports.out.FranquiciaRepositoryPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CrearFranquiciaUseCase implements CrearFranquiciaInputPort {

	private final FranquiciaRepositoryPort franquiciaRepositoryPort;

	@Override
	public Franquicia guardar(Franquicia franquicia) {
		return franquiciaRepositoryPort.guardar(franquicia);
	}

}
