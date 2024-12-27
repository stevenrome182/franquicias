package com.prueba.tecnica.franquicias.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarNombreProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.ActualizarStockInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.CrearProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.EliminarProductoInputPort;
import com.prueba.tecnica.franquicias.domain.ports.in.ProductosMasStockInputPort;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.NombreProductoDTO;
import com.prueba.tecnica.franquicias.infrastructure.rest.dto.ProductoConMasStockDTO;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	private final CrearProductoInputPort crearProductoInputPort;
	private final EliminarProductoInputPort eliminarProductoInputPort;
	private final ActualizarStockInputPort actualizarStockInputPort;
	private final ProductosMasStockInputPort productosMasStockInputPort;
	private final ActualizarNombreProductoInputPort actualizarNombreProductoInputPort;

	public ProductoService(CrearProductoInputPort crearProductoInputPort,
			EliminarProductoInputPort eliminarProductoInputPort, ActualizarStockInputPort bucarProductoPorIdInputPort,
			ProductosMasStockInputPort productosMasStockInputPort,
			ActualizarNombreProductoInputPort actualizarNombreProductoInputPort) {
		this.crearProductoInputPort = crearProductoInputPort;
		this.eliminarProductoInputPort = eliminarProductoInputPort;
		this.actualizarStockInputPort = bucarProductoPorIdInputPort;
		this.productosMasStockInputPort = productosMasStockInputPort;
		this.actualizarNombreProductoInputPort = actualizarNombreProductoInputPort;
	}

	@Transactional
	public Producto crearProducto(String nombre, int stock, Long sucursalId) {
		Sucursal sucursal = new Sucursal();
		sucursal.setId(sucursalId);
		Producto producto = new Producto(nombre, stock, sucursal);
		return crearProductoInputPort.guardar(producto);
	}

	@Transactional
	public void eliminarProducto(Long id) {
		eliminarProductoInputPort.eliminar(id);
	}

	@Transactional
	public void actualizarStock(Long id, int cantidad) {
		actualizarStockInputPort.actualizarStock(id, cantidad);
	}

	public List<ProductoConMasStockDTO> productosMasStock(Long franquiciaId) {
		return productosMasStockInputPort.productosMasStock(franquiciaId);
	}

	@Transactional
	public void actualizarNombre(long id, NombreProductoDTO nombreProductoDTO) {
		actualizarNombreProductoInputPort.actualizarNombre(id, nombreProductoDTO.getNombre());
	}

}
