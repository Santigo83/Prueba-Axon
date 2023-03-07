package com.axon.pruebaaxon.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axon.pruebaaxon.repositorio.InfoEstacionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class SubestacionServicio {
	
	@Autowired
	InfoEstacionRepo infoEstacionRepo;

	public SubestacionServicio(InfoEstacionRepo infoEstacionRepo) {
		super();
		this.infoEstacionRepo = infoEstacionRepo;
	}

	@PersistenceContext
	EntityManager en;
	public List<Object[]> listarSubestacion(){
		Query query = en.createNativeQuery("SELECT DISTINCT subestacion, subestacion FROM info_estacion;");
		return query.getResultList();
	}
}
