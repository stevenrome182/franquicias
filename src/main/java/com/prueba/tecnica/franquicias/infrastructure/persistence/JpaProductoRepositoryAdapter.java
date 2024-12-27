package com.prueba.tecnica.franquicias.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.application.mapper.ProductoMapper;
import com.prueba.tecnica.franquicias.application.mapper.SucursalMapper;
import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.domain.ports.out.ProductoRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.ProductoEntity;

@Component
public class JpaProductoRepositoryAdapter implements ProductoRepositoryPort {

	private final JpaProductoRepository jpaProductoRepository;

	public JpaProductoRepositoryAdapter(JpaProductoRepository jpaProductoRepository) {
		this.jpaProductoRepository = jpaProductoRepository;
	}

	@Override
	public Producto guardar(Producto producto) {
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setId(producto.getId());
		productoEntity.setNombre(producto.getNombre());
		productoEntity.setStock(producto.getStock());
		productoEntity.setSucursal(SucursalMapper.toEntity(producto.getSucursal()));
		ProductoEntity productoEntitySaved = jpaProductoRepository.save(productoEntity);
		producto.setId(productoEntitySaved.getId());
		return producto;
	}

	@Override
	public Producto actualizar(Producto producto) {
		Optional<ProductoEntity> productoEntityOptional = jpaProductoRepository.findById(producto.getId());
		if (productoEntityOptional.isPresent()) {
			ProductoEntity productoEntity = productoEntityOptional.get();
			productoEntity.setNombre(producto.getNombre());
			productoEntity.setStock(producto.getStock());
			jpaProductoRepository.save(productoEntity);
			return producto;
		}
		return null;
	}

	@Override
	public void eliminar(Long id) {
		jpaProductoRepository.deleteById(id);
	}

	@Override
	public Optional<Producto> buscarPorId(Long id) {
		return jpaProductoRepository.findById(id).map(ProductoMapper::toDomain);
	}

	@Override
	public Producto productoMasStock(Long sucursalId) {
		ProductoEntity productoEntity = jpaProductoRepository.findProductoConMasStockBySucursalId(sucursalId);
		if (productoEntity != null) {
			return ProductoMapper.toDomain(productoEntity);
		}
		return null;
	}

}
