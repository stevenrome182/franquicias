package com.prueba.tecnica.franquicias.infrastructure.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.franquicias.application.service.ProductoService;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreProductoDTO;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoConMasStockDTO;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoDTO;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@PostMapping
	public ResponseEntity<Void> crearProducto(@RequestBody ProductoDTO productoDTO) {
		productoService.crearProducto(productoDTO.getNombre(), productoDTO.getStock(), productoDTO.getSucursal());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
		productoService.eliminarProducto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping("/{id}/stock")
	public ResponseEntity<Void> modificarStock(@PathVariable Long id, @RequestParam int cantidad) {
		productoService.actualizarStock(id, cantidad);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{franquiciaId}/productos-con-mas-stock")
	public ResponseEntity<List<ProductoConMasStockDTO>> obtenerProductosConMasStock(@PathVariable Long franquiciaId) {
		List<ProductoConMasStockDTO> resultados = productoService.productosMasStock(franquiciaId);
		return ResponseEntity.ok(resultados);
	}

	@PatchMapping("/{id}/nombre")
	public ResponseEntity<Void> modificarNombre(@PathVariable Long id,
			@RequestBody NombreProductoDTO nombreProductoDTO) {
		productoService.actualizarNombre(id, nombreProductoDTO);
		return ResponseEntity.noContent().build();
	}

}
