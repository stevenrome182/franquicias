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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

	private final ProductoService productoService;

	@Operation(summary = "Crea un producto.", description = "Crea un producto.")
	@ApiResponse(responseCode = "201", description = "Franquicia creada")
	@PostMapping
	public ResponseEntity<Void> crearProducto(@RequestBody ProductoDTO productoDTO) {
		productoService.crearProducto(productoDTO.getNombre(), productoDTO.getStock(), productoDTO.getSucursal());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(summary = "Elimina un producto.", description = "Elimina un producto por ID.")
	@ApiResponse(responseCode = "200", description = "Producto eliminido")
	@ApiResponse(responseCode = "404", description = "Producto a eliminar no encontrado")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
		productoService.eliminarProducto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Actualiza el stock.", description = "Actualiza el stock de un producto.")
	@ApiResponse(responseCode = "204", description = "Stock de producto actualizado")
	@ApiResponse(responseCode = "404", description = "Producto no encontrado")
	@ApiResponse(responseCode = "400", description = "La cantidad de stock negativa")
	@PatchMapping("/{id}/stock")
	public ResponseEntity<Void> modificarStock(@PathVariable Long id, @RequestParam int cantidad) {
		productoService.actualizarStock(id, cantidad);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Actualiza el nombre del producto.", description = "Actualiza el nombre de un producto.")
	@ApiResponse(responseCode = "204", description = "Nombre de producto actualizado")
	@ApiResponse(responseCode = "404", description = "Producto no encontrado")
	@PatchMapping("/{id}/nombre")
	public ResponseEntity<Void> modificarNombre(@PathVariable Long id,
			@RequestBody NombreProductoDTO nombreProductoDTO) {
		productoService.actualizarNombre(id, nombreProductoDTO);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Obtiene los productos con mas stock.", description = "Obtiene lso productos con mas stock por ID franquicia.")
	@ApiResponse(responseCode = "200", description = "Listado de productos con mas stock")
	@ApiResponse(responseCode = "404", description = "Franquicia no encontrada")
	@GetMapping("/{franquiciaId}/productos-con-mas-stock")
	public ResponseEntity<List<ProductoConMasStockDTO>> obtenerProductosConMasStock(@PathVariable Long franquiciaId) {
		List<ProductoConMasStockDTO> resultados = productoService.productosMasStock(franquiciaId);
		return ResponseEntity.ok(resultados);
	}

	@Operation(summary = "Obtiene el listado de productos.", description = "Obtiene el listado de productos.")
	@ApiResponse(responseCode = "200", description = "Lista de productos")
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> obtenerProductos() {
		List<ProductoDTO> productos = productoService.obtenerProductos();
		return ResponseEntity.ok(productos);
	}

}
