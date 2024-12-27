package com.prueba.tecnica.franquicias.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.SucursalEntity;

@Repository
public interface JpaSucursalRepository extends JpaRepository<SucursalEntity, Long> {

	List<SucursalEntity> findByFranquiciaId(Long franquiciaId);
	
}
