package com.axon.pruebaaxon.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axon.pruebaaxon.modelo.InfoEstacion;
import com.axon.pruebaaxon.servicio.InfoEstacionServicio;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("infoEstacions")
public class InfoEstacionControlador {

	private InfoEstacionServicio infoEstacionServicio;
	
	public InfoEstacionControlador(InfoEstacionServicio infoEstacionServicio) {
		super();
		this.infoEstacionServicio = infoEstacionServicio;
	}

	@PostMapping("/upload-customers-data")
	public ResponseEntity<?> cargarInfoEstacionData (@RequestParam("file")MultipartFile file)
	{
		infoEstacionServicio.guardarDatos(file);
		
		return ResponseEntity
                .ok(Map.of("Message" , " Datos de clientes cargados y guardados en la base de datos con éxito"));
	}
	
	
/*	public  ResponseEntity<List<InfoEstacion>> getInfoEstacions()
	{//ResponseEntity<List<Customer>> getCustomers(){
       return new ResponseEntity<>(infoEstacionServicio.getInfoEstacion(), HttpStatus.FOUND);//ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
    }
  
	
}
*/
}