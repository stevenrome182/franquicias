package com.prueba.tecnica.franquicias.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.franquicias.application.service.FranquiciaService;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.FranquiciaDTO;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreFranquiciaDTO;

@RestController
@RequestMapping("/franquicia")
public class FranquiciaController {

	private final FranquiciaService franquiciaService;

	public FranquiciaController(FranquiciaService franquiciaService) {
		this.franquiciaService = franquiciaService;
	}

	@PostMapping
	public ResponseEntity<Void> crearFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
		franquiciaService.crearFranquicia(franquiciaDTO.getNombre());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}/nombre")
	public ResponseEntity<Void> modificarNombre(@PathVariable Long id,
			@RequestBody NombreFranquiciaDTO nombreFranquiciaDTO) {
		franquiciaService.actualizarNombre(id, nombreFranquiciaDTO);
		return ResponseEntity.noContent().build();
	}

}
