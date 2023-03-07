package com.axon.pruebaaxon.servicio;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.axon.pruebaaxon.modelo.InfoEstacion;
import com.axon.pruebaaxon.repositorio.InfoEstacionRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InfoEstacionServicio {
	
	private InfoEstacionRepo infoEstacionRepo;
	
	
	
	public InfoEstacionServicio(InfoEstacionRepo infoEstacionRepo) {
		super();
		this.infoEstacionRepo = infoEstacionRepo;
	}



	public void guardarDatos(MultipartFile file)
	{
		if(ExcelCargaServicio.isValidExcelFile(file))
		{
			try {
				List<InfoEstacion> infoEstacions = ExcelCargaServicio.consultarInformacionDeLaEstacionDelExcel(file.getInputStream());
				this.infoEstacionRepo.saveAll(infoEstacions);
			}catch(IOException e)
			{
				throw new IllegalArgumentException("El archivo no es valido");
			}
		}
	}
	
	
	
	
}
