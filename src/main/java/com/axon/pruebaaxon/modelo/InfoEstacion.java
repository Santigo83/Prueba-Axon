package com.axon.pruebaaxon.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoEstacion {
	
	public InfoEstacion() {
		super();
	}
	public InfoEstacion(int id, int totalHorasDeFalla, int totalDeCausas, Date fecha, String zona,
			String subestacion, int nivelDeTension) {
		super();
		this.id = id;
		this.totalHorasDeFalla = totalHorasDeFalla;
		this.totalDeCausas = totalDeCausas;
		this.fecha = fecha;
		this.zona = zona;
		Subestacion = subestacion;
		this.nivelDeTension = nivelDeTension;
	}
	@Id
	private int id;
	private int totalHorasDeFalla;
	private int totalDeCausas;
	private Date fecha;
	private String zona;
	private String Subestacion;
	private int nivelDeTension;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalHorasDeFalla() {
		return totalHorasDeFalla;
	}
	public void setTotalHorasDeFalla(int totalHorasDeFalla) {
		this.totalHorasDeFalla = totalHorasDeFalla;
	}
	public int getTotalDeCausas() {
		return totalDeCausas;
	}
	public void setTotalDeCausas(int totalDeCausas) {
		this.totalDeCausas = totalDeCausas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getSubestacion() {
		return Subestacion;
	}
	public void setSubestacion(String subestacion) {
		Subestacion = subestacion;
	}
	public int getNivelDeTension() {
		return nivelDeTension;
	}
	public void setNivelDeTension(int nivelDeTension) {
		this.nivelDeTension = nivelDeTension;
	}
	
	
	
	
	


}
