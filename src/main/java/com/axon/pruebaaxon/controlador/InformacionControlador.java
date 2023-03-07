package com.axon.pruebaaxon.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.axon.pruebaaxon.modelo.InfoEstacion;
import com.axon.pruebaaxon.servicio.InfoEstacionFrontServicioImplement;
import com.axon.pruebaaxon.servicio.NivelDeTensionServicio;
import com.axon.pruebaaxon.servicio.SubestacionServicio;

@Controller
@RequestMapping("/")
public class InformacionControlador {
	
	@Autowired
	InfoEstacionFrontServicioImplement estacionFrontServicioImplement;
	@Autowired
	SubestacionServicio subestacionServicio;
	@Autowired
	NivelDeTensionServicio nivelDeTensionServicio;
	
	private Long ver=new Date().getTime();
	
	@ResponseBody
	@RequestMapping("/")
	ModelAndView home() {
		ModelAndView mav=new ModelAndView();
		

		mav.setViewName("index");
		mav.addObject("ver",ver);
		mav.addObject("videos", estacionFrontServicioImplement.listarZonas());
		
		mav.setViewName("index");
		mav.addObject("ver",ver);
		mav.addObject("subestaciones", subestacionServicio.listarSubestacion());
		
		mav.setViewName("index");
		mav.addObject("ver",ver);
		mav.addObject("tensiones", nivelDeTensionServicio.listarNivelDeTension());

		
		
		return mav;
		
	}
	
	@RequestMapping(value="/api")
    @ResponseBody
    HashMap<String,Object> api(
    		@RequestParam(value="from") String from1,
    		@RequestParam(value="to") String to1,
    		@RequestParam(value="video") String video1
    		) {
    	HashMap<String,Object> r=new HashMap<String,Object>();
    	
    	r.put( "subsdia" , estacionFrontServicioImplement.getSubscriptoresDia( from1, to1, video1) );
       	
        
    	return r;
    	}
	
	
}
	
	
	/*
	@GetMapping("/visualizar")
	public String visualizarZona(ModelMap modelo)
	{
		List<InfoEstacion> infoEstacions = estacionFrontServicioImplement.listarZonas();
		modelo.addAttribute("infoEstacions", infoEstacions);
		
		return "index";
	}
	
*/

