package com.prueba.tecnica.franquicias.application.mapper;

import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.FranquiciaEntity;

public class FranquiciaMapper {

	private FranquiciaMapper() {
	}

	public static Franquicia toDomain(FranquiciaEntity entity) {
		if (entity == null) {
			return null;
		}
		Franquicia franquicia = new Franquicia();
		franquicia.setId(entity.getId());
		franquicia.setNombre(entity.getNombre());
		return franquicia;
	}

	public static FranquiciaEntity toEntity(Franquicia domain) {
		if (domain == null) {
			return null;
		}
		FranquiciaEntity entity = new FranquiciaEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		return entity;
	}

}
