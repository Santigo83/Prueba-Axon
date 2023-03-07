package com.axon.pruebaaxon.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axon.pruebaaxon.modelo.UserAxon;

public interface UserAxonRepo extends JpaRepository<UserAxon, Long>{

	public UserAxon findByEmail(String email);
}
