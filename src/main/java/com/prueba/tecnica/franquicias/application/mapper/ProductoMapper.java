package com.prueba.tecnica.franquicias.application.mapper;

import com.prueba.tecnica.franquicias.domain.model.Producto;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.ProductoEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductoMapper {

	public static Producto toDomain(ProductoEntity entity) {
		Producto producto = new Producto(entity.getNombre(), entity.getStock(),
				SucursalMapper.toDomain(entity.getSucursal()));
		producto.setId(entity.getId());
		return producto;
	}

}
