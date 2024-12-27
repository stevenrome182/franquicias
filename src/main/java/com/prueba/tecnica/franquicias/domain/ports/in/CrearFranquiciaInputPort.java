package com.prueba.tecnica.franquicias.domain.ports.in;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;

public interface CrearFranquiciaInputPort {

	Franquicia guardar(Franquicia franquicia);

}
