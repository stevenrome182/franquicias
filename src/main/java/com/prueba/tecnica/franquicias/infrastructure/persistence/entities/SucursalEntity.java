package com.prueba.tecnica.franquicias.infrastructure.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursales")
public class SucursalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "franquicia_id", nullable = false)
	private FranquiciaEntity franquicia;

	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
	private List<ProductoEntity> productos;

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

	public FranquiciaEntity getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(FranquiciaEntity franquicia) {
		this.franquicia = franquicia;
	}

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}
	
}
