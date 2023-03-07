package com.axon.pruebaaxon.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.axon.pruebaaxon.modelo.InfoEstacion;

import jakarta.persistence.NamedNativeQueries;

public interface InfoEstacionRepo extends JpaRepository<InfoEstacion, Integer>{
	
	
	
	
}


