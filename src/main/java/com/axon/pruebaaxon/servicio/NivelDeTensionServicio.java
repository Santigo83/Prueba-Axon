package com.axon.pruebaaxon.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axon.pruebaaxon.repositorio.InfoEstacionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class NivelDeTensionServicio {

	@Autowired
	InfoEstacionRepo infoEstacionRepo;

	

	public NivelDeTensionServicio(InfoEstacionRepo infoEstacionRepo) {
		super();
		this.infoEstacionRepo = infoEstacionRepo;
	}
	
	@PersistenceContext
	EntityManager en;
	public List<Object[]> listarNivelDeTension(){
		Query query = en.createNativeQuery("SELECT DISTINCT nivel_de_tension, nivel_de_tension FROM info_estacion;");
		return query.getResultList();
	}
}
