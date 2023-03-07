package com.axon.pruebaaxon.servicio;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.axon.pruebaaxon.dto.UsuarioRegistroDTO;
import com.axon.pruebaaxon.modelo.UserAxon;


public interface UsuarioServicio extends UserDetailsService{
	
	public UserAxon guardarUsuarios(UsuarioRegistroDTO registroDTO);
	

}
