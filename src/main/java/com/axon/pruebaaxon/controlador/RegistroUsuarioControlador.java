package com.axon.pruebaaxon.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axon.pruebaaxon.dto.UsuarioRegistroDTO;
import com.axon.pruebaaxon.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	
	@Autowired
	UsuarioServicio usuarioServicio;

	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO RetornarNuevoUusuarioRegistroDTO()
	{
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String MostrarFormularioDeRegistro()
	{
		return "registro";
	}
	@PostMapping
	public String RegistrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO)
	{
		usuarioServicio.guardarUsuarios(registroDTO);
		return "redirect:/registro?exito";
	}
	

	
	
}
