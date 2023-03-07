package com.axon.pruebaaxon.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="rol_axon")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
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
	
	
	
	
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
	public Rol() {
		super();
	}
	
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	

}
