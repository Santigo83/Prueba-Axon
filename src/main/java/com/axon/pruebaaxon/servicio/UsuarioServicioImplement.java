package com.axon.pruebaaxon.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.axon.pruebaaxon.dto.UsuarioRegistroDTO;
import com.axon.pruebaaxon.modelo.Rol;
import com.axon.pruebaaxon.modelo.UserAxon;
import com.axon.pruebaaxon.repositorio.UserAxonRepo;

@Service
public class UsuarioServicioImplement implements UsuarioServicio {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	UserAxonRepo userAxonRepo;
	
	
	
	public UsuarioServicioImplement(UserAxonRepo userAxonRepo) {
		super();
		this.userAxonRepo = userAxonRepo;
	}

	
	@Override
	public UserAxon guardarUsuarios(UsuarioRegistroDTO registroDTO) {
		
		UserAxon userAxon = new UserAxon(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(), 
				passwordEncoder.encode(registroDTO.getClave()), Arrays.asList(new Rol("ROLE_USER")));
		return userAxonRepo.save(userAxon);
	}


	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAxon userAxon = userAxonRepo.findByEmail(username);
		if(userAxon == null)
		{
			throw new UsernameNotFoundException("Usuario o contraseña incorrectos");
		}
		return new User(userAxon.getEmail(), userAxon.getClave(), mapearAutoridadesRoles(userAxon.getRoles()));
			
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());	
	}
	
	
}
