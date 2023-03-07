package com.axon.pruebaaxon.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.axon.pruebaaxon.modelo.InfoEstacion;

public class ExcelCargaServicio
{

	public static boolean isValidExcelFile(MultipartFile file)
	{
		return Objects.equals(file.getContentType(),
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}


	public static List<InfoEstacion> consultarInformacionDeLaEstacionDelExcel(InputStream inputStream) 
	{
		List<InfoEstacion> infoEstacions = new ArrayList<>();
		
	

		try {
			 XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				XSSFSheet sheet = workbook.getSheet("infoEstacions");
				int rowIndex = 0;
				 for (Row row : sheet){
				    
					if (rowIndex == 0)
				       {
				           rowIndex++;
				           continue;
				       }
				 
				       Iterator<Cell> cellIterator = row.iterator();
				       int cellIndex = 0;
				       
				       InfoEstacion infoEstacion = new InfoEstacion();
				       
				       while (cellIterator.hasNext()){
				           Cell cell = cellIterator.next();
				           switch (cellIndex){
				           	   case 0 -> infoEstacion.setId((int) cell.getNumericCellValue());
				               case 1 -> infoEstacion.setTotalHorasDeFalla((int)cell.getNumericCellValue());
				               case 2 -> infoEstacion.setTotalDeCausas((int)cell.getNumericCellValue());
				               case 3 -> infoEstacion.setFecha(cell.getDateCellValue());
				               case 4 -> infoEstacion.setZona(cell.getStringCellValue());
				               case 5 -> infoEstacion.setSubestacion(cell.getStringCellValue());
				               case 6 -> infoEstacion.setNivelDeTension((int)cell.getNumericCellValue());
				               default -> {
				               }
				           }
				           cellIndex++;
				       }
				       infoEstacions.add(infoEstacion);

				 }
		}catch (IOException e) {

			e.printStackTrace();
			 }
		
		return infoEstacions;
	
	}
	


		

}
