package com.prueba.tecnica.franquicias.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.ProductoEntity;

@Repository
public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Long> {
	
    @Query("SELECT p FROM ProductoEntity p JOIN p.sucursal s WHERE s.id = :sucursalId ORDER BY p.stock DESC LIMIT 1")
    ProductoEntity findProductoConMasStockBySucursalId(@Param("sucursalId") Long sucursalId);

}
