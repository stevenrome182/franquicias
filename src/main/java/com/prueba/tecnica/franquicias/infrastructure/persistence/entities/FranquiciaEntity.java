package com.prueba.tecnica.franquicias.infrastructure.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "franquicias")
public class FranquiciaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // SERIAL en PostgreSQL
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
	private List<SucursalEntity> sucursales;

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SucursalEntity> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<SucursalEntity> sucursales) {
		this.sucursales = sucursales;
	}

}
