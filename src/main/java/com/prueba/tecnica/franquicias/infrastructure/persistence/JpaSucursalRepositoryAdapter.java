package com.prueba.tecnica.franquicias.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.franquicias.application.mapper.FranquiciaMapper;
import com.prueba.tecnica.franquicias.application.mapper.SucursalMapper;
import com.prueba.tecnica.franquicias.domain.model.Sucursal;
import com.prueba.tecnica.franquicias.domain.ports.out.SucursalRepositoryPort;
import com.prueba.tecnica.franquicias.infrastructure.persistence.entities.SucursalEntity;

@Component
public class JpaSucursalRepositoryAdapter implements SucursalRepositoryPort {

	private final JpaSucursalRepository jpaSucursalRepository;

	public JpaSucursalRepositoryAdapter(JpaSucursalRepository jpaSucursalRepository) {
		this.jpaSucursalRepository = jpaSucursalRepository;
	}

	@Override
	public Sucursal guardar(Sucursal sucursal) {
		SucursalEntity sucursalSaved = jpaSucursalRepository.save(SucursalMapper.toEntity(sucursal));
		return SucursalMapper.toDomain(sucursalSaved);
	}

	@Override
	public Sucursal actaulizar(Sucursal sucursal) {
		Optional<SucursalEntity> sucursalEntityOptional = jpaSucursalRepository.findById(sucursal.getId());
		if (sucursalEntityOptional.isPresent()) {
			SucursalEntity productoEntity = sucursalEntityOptional.get();
			productoEntity.setNombre(sucursal.getNombre());
			productoEntity.setFranquicia(FranquiciaMapper.toEntity(sucursal.getFranquicia()));
			jpaSucursalRepository.save(productoEntity);
			return sucursal;
		}
		return null;
	}

	@Override
	public Optional<Sucursal> obtenrSucursalById(Long id) {
		return jpaSucursalRepository.findById(id).map(SucursalMapper::toDomain);
	}

	@Override
	public List<Sucursal> obtenerSucursalesByFranquicia(Long id) {
		return jpaSucursalRepository.findByFranquiciaId(id).stream().map(SucursalMapper::toDomain).toList();
	}

}
