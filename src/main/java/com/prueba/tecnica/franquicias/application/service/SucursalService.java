package com.prueba.tecnica.franquicias.application.service;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreSucursalInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearSucursalInputPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreSucursalDTO;

import jakarta.transaction.Transactional;

@Service
public class SucursalService {

	private final CrearSucursalInputPort crearSucursalInputPort;
	private final ActualizarNombreSucursalInputPort actualizarNombreSucursalInputPort;

	public SucursalService(CrearSucursalInputPort crearSucursalInputPort,
			ActualizarNombreSucursalInputPort actualizarNombreSucursalInputPort) {
		this.crearSucursalInputPort = crearSucursalInputPort;
		this.actualizarNombreSucursalInputPort = actualizarNombreSucursalInputPort;
	}

	@Transactional
	public Sucursal crearSucursal(String nombre, Long feanquiciaId) {
		Franquicia franquicia = new Franquicia();
		franquicia.setId(feanquiciaId);
		Sucursal sucursal = new Sucursal(nombre, franquicia);
		return crearSucursalInputPort.guardar(sucursal);
	}

	@Transactional
	public void actualizarNombre(Long id, NombreSucursalDTO nombreSucursalDTO) {
		actualizarNombreSucursalInputPort.actualizarNombre(id, nombreSucursalDTO.getNombre());
	}

}
