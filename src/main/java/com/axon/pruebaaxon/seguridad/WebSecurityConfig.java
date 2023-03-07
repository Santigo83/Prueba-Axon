package com.axon.pruebaaxon.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.axon.pruebaaxon.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
	UsuarioServicio usuarioServicio;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public DaoAuthenticationProvider authenticationProvider1() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
	
		return http.csrf()

				.disable()

				.authorizeHttpRequests()

				.requestMatchers("/registro**")

				.permitAll()

				.anyRequest()

				.authenticated()

				.and()

				.formLogin()
				
				.loginPage("/login")

				.permitAll()

				.and()

				.logout()

				.invalidateHttpSession(true)

				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
				.logoutSuccessUrl("/login?logut")
				
				.permitAll()
				
				.and()
				
				.build();
	
	}
	
		
		
	
}
