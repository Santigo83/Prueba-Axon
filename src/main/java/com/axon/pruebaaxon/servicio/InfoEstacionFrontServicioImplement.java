package com.axon.pruebaaxon.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axon.pruebaaxon.modelo.InfoEstacion;
import com.axon.pruebaaxon.repositorio.InfoEstacionRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Service
public class InfoEstacionFrontServicioImplement {

	@Autowired 
	InfoEstacionRepo infoEstacionRepo;
	
	public InfoEstacionFrontServicioImplement(InfoEstacionRepo infoEstacionRepo) {
		super();
		this.infoEstacionRepo = infoEstacionRepo;
	}
	
	
	@PersistenceContext
	EntityManager em;
	public List<Object[]> listarZonas(){
		Query query = em.createNativeQuery("SELECT DISTINCT zona, zona FROM info_estacion;");
		return query.getResultList();
	}

	/*
	 private List<Object[]> getSubscriptoresSemana(String from1, String to1, String video1) {
	    	String sql="SELECT DAYNAME(date),sum(subscribers) FROM youtube.subscribers ";
	    	String where=getConditionalSql(from1, to1, video1);
	    	
	    	sql+=where+" group by WEEKDAY(date)";
	               
	        return getSqlValues(sql,from1, to1, video1);
	    	}
	 */   
	    public List<Object[]> getSubscriptoresDia(String from1, String to1, String video1) {
	    	String sql="SELECT fecha,sum(total_horas_de_falla) FROM info_estacion ";
	    	String where=getConditionalSql(from1, to1, video1);
	    	
	    	sql+=where+" group by fecha order by fecha desc";
	               
	        return getSqlValues(sql,from1, to1, video1);
	    	} 


	    public List<Object[]> getSqlValues(String sql,String from1, String to1, String video1) {
	    	Query query = em.createNativeQuery(sql);
	       	
	    	if ( !from1.equals("") ) query.setParameter("from", from1);
	    	if ( !to1.equals("") ) query.setParameter("to", to1);
	    	if ( !video1.equals("") ) query.setParameter("video", video1);
	               
	        return query.getResultList();    	
	    	}

	    public String getConditionalSql(String from1, String to1, String video1) {
	    	String where="";
	    	if ( !from1.equals("") ) where+=" date >= :from ";

	    	if ( !to1.equals("") ) {
	    		if ( !where.equals("") ) where+=" and ";
	    		where+=" date <= :to ";
	    		}

	    	if ( !video1.equals("") ) {
	    		if ( !where.equals("") ) where+=" and ";
	    		where+=" video = :video ";
	    		}
	    	
	    	if ( !where.equals("") ) where=" where "+where;
	    	
	    	return where;
	    	}    
	    	
	
	

}
