package com.axon.pruebaaxon.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.axon.pruebaaxon.dto.UsuarioRegistroDTO;
import com.axon.pruebaaxon.modelo.InfoEstacion;
import ch.qos.logback.core.model.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Controller
public class RegistroControlador {
	
	
	@GetMapping("/login")
	public String iniciarSesion()
	{
		return "login";
	}
	
	
	
}

