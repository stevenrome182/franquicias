package com.prueba.tecnica.franquicias.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.FranquiciaEntity;

@Repository
public interface JpaFranquiciaRepository extends JpaRepository<FranquiciaEntity, Long> {

}
