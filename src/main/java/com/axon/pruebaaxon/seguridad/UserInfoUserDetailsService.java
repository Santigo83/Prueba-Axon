/*
package com.axon.pruebaaxon.seguridad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.axon.pruebaaxon.dto.UsuarioRegistroDTO;
import com.axon.pruebaaxon.servicio.UsuarioServicio;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(UsuarioRegistroDTO registroDTO) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = usuarioServicio.guardarUsuarios(registroDTO);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        
    }
}

*/