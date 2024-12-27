package com.prueba.tecnica.franquicias.domain.ports.out;

import java.util.Optional;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;

public interface FranquiciaRepositoryPort {

	Franquicia guardar(Franquicia franquicia);

	Franquicia actualizar(Franquicia franquicia);

	Optional<Franquicia> obtenerFranquiciaById(Long id);

}
