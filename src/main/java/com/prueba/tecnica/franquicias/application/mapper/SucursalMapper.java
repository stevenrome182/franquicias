package com.prueba.tecnica.franquicias.application.mapper;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.FranquiciaEntity;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.SucursalEntity;

public class SucursalMapper {

	private SucursalMapper() {

	}

	public static Sucursal toDomain(SucursalEntity sucursalEntity) {
		if (sucursalEntity == null) {
			return null;
		}
		Sucursal sucursal = new Sucursal();
		sucursal.setId(sucursalEntity.getId());
		sucursal.setNombre(sucursalEntity.getNombre());
		if (sucursalEntity.getFranquicia() != null) {
			Franquicia franquicia = FranquiciaMapper.toDomain(sucursalEntity.getFranquicia());
			sucursal.setFranquicia(franquicia);
		}
		return sucursal;
	}

	public static SucursalEntity toEntity(Sucursal domain) {
		if (domain == null) {
			return null;
		}
		SucursalEntity entity = new SucursalEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		if (domain.getFranquicia() != null) {
			FranquiciaEntity franquiciaEntity = new FranquiciaEntity();
			franquiciaEntity.setId(domain.getFranquicia().getId());
			entity.setFranquicia(franquiciaEntity);
		}

		return entity;
	}

}
