package com.prueba.tecnica.franquicias.application.service;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreFranquiciaInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearFranquiciaInputPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreFranquiciaDTO;

import jakarta.transaction.Transactional;

@Service
public class FranquiciaService {

	private final CrearFranquiciaInputPort crearFranquiciaInputPort;
	private final ActualizarNombreFranquiciaInputPort actualizarNombreFranquiciaInputPort;

	public FranquiciaService(CrearFranquiciaInputPort crearFranquiciaInputPort,
			ActualizarNombreFranquiciaInputPort actualizarNombreFranquiciaInputPort) {
		this.crearFranquiciaInputPort = crearFranquiciaInputPort;
		this.actualizarNombreFranquiciaInputPort = actualizarNombreFranquiciaInputPort;
	}

	@Transactional
	public Franquicia crearFranquicia(String nombre) {
		Franquicia franquicia = new Franquicia(nombre);
		return crearFranquiciaInputPort.guardar(franquicia);
	}

	@Transactional
	public void actualizarNombre(Long id, NombreFranquiciaDTO nombreFranquiciaDTO) {
		actualizarNombreFranquiciaInputPort.actualizarNombre(id, nombreFranquiciaDTO.getNombre());
	}

}
