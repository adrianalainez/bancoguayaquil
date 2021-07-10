package com.gye.test.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gye.test.model.RegistroConsulta;
import com.gye.test.repositorio.contrato.IRegistroConsultaDAO;
import com.gye.test.service.contrato.IRegistroConsultaService;

@Service
public class RegistroConsultaService  implements IRegistroConsultaService{
	
	@Autowired 
	IRegistroConsultaDAO repositorio  ;
	
	
	@Override
	 public String consultarEdad(String Nombre) {
		  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fecha = sdf.format(new Date());
			String resultado;
			
			RegistroConsulta consultaRegistro =  repositorio.consultarNombreLogDia(Nombre,fecha);
			
			if(consultaRegistro != null && consultaRegistro.getNombre().equals(Nombre) && consultaRegistro.getFechaConsulta().equals(fecha)) {
				
				resultado ="Nombre ya fue consultado el dia de hoy"; 
				
			}else {
				 
				RestTemplate plantilla = new RestTemplate();
			     
				 resultado = plantilla.getForObject("https://api.agify.io?name=" + Nombre, String.class);		    
			   
			     JSONObject objetoJson = new JSONObject(resultado);
			     int edad = objetoJson.getInt("age");
			     String nombre = objetoJson.getString("name");
			     
			     repositorio.guardarLogs(nombre, edad, "S", fecha);
			     
			}
			
			 return resultado;
			 
	 }
	  
	@Override
	  public List<RegistroConsulta> consultarListado(String Fecha) {
		  
			 List<RegistroConsulta> resultado = null;
			 				
			 resultado =  repositorio.consultarListadoFecha(Fecha) ;
			 
			 
			 return resultado;
	  }

}
