package com.prueba.tecnica.franquicias.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.franquicias.application.service.SucursalService;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreSucursalDTO;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.SucursalDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalController {

	private final SucursalService sucursalService;

	@Operation(summary = "Crea una sucursal", description = "Crea una sucursal.")
	@ApiResponse(responseCode = "201", description = "Franquicia creada")
	@PostMapping
	public ResponseEntity<Void> crearSucursal(@RequestBody SucursalDTO sucursalDTO) {
		sucursalService.crearSucursal(sucursalDTO.getNombre(), sucursalDTO.getFranquicia());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el nombre de la sucursal.", description = "Actualiza el nombre de la sucursal.")
	@ApiResponse(responseCode = "204", description = "Sucursal actualizada")
	@ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
	@PatchMapping("/{id}/nombre")
	public ResponseEntity<Void> modificarNombre(@PathVariable Long id,
			@RequestBody NombreSucursalDTO nombreSucursalDTO) {
		sucursalService.actualizarNombre(id, nombreSucursalDTO);
		return ResponseEntity.noContent().build();
	}

}
