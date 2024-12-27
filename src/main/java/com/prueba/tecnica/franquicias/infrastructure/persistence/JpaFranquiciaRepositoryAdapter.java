package com.prueba.tecnica.franquicias.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.application.mapper.FranquiciaMapper;
import com.prueba.tecnica.franquicias.domain.model.Franquicia;
import com.prueba.tecnica.franquicias.domain.ports.out.FranquiciaRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.FranquiciaEntity;

@Component
public class JpaFranquiciaRepositoryAdapter implements FranquiciaRepositoryPort {

	private final JpaFranquiciaRepository jpaFranquiciaRepository;

	public JpaFranquiciaRepositoryAdapter(JpaFranquiciaRepository jpaFranquiciaRepository) {
		this.jpaFranquiciaRepository = jpaFranquiciaRepository;
	}

	@Override
	public Franquicia guardar(Franquicia franquicia) {
		FranquiciaEntity franquiciaEntity = new FranquiciaEntity();
		franquiciaEntity.setNombre(franquicia.getNombre());
		franquiciaEntity.setId(franquicia.getId());
		FranquiciaEntity franquiciaSaved = jpaFranquiciaRepository.save(franquiciaEntity);
		franquicia.setId(franquiciaSaved.getId());
		return franquicia;
	}

	@Override
	public Franquicia actualizar(Franquicia franquicia) {
		Optional<FranquiciaEntity> franquiciaEntityOptional = jpaFranquiciaRepository.findById(franquicia.getId());
		if (franquiciaEntityOptional.isPresent()) {
			FranquiciaEntity franquiciaEntity = franquiciaEntityOptional.get();
			franquiciaEntity.setNombre(franquicia.getNombre());
			jpaFranquiciaRepository.save(franquiciaEntity);
			return franquicia;
		}
		return null;
	}

	@Override
	public Optional<Franquicia> obtenerFranquiciaById(Long id) {
		return jpaFranquiciaRepository.findById(id).map(FranquiciaMapper::toDomain);
	}

}
