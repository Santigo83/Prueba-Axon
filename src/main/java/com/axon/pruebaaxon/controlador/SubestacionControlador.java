package com.axon.pruebaaxon.controlador;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.axon.pruebaaxon.servicio.SubestacionServicio;


@Controller
@RequestMapping("/")
public class SubestacionControlador {
	
	
	private Long ver=new Date().getTime();
	
	@Autowired
	SubestacionServicio subestacionServicio;
	
	@ResponseBody
	@RequestMapping("s")
	ModelAndView subestacionHome() {
		ModelAndView man=new ModelAndView();
		man.setViewName("index");
		man.addObject("ver",ver);
		man.addObject("subestaciones", subestacionServicio.listarSubestacion());
		
		return man;
}

}

	