package com.gye.test.RegistroController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gye.test.model.RegistroConsulta;
import com.gye.test.service.contrato.IRegistroConsultaService;

@RestController
public class RegistroConsultaController {

	@Autowired 
	 private IRegistroConsultaService service;
	
	@GetMapping(value="consultaredad/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)	
	public String consultarEdad(@PathVariable("nombre") String Nombre) {
		
		   String  result = service.consultarEdad(Nombre);
			
		return result;
	}
	

	@GetMapping(value="consultarlistado/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)	
    public List<RegistroConsulta> consultarListado(@PathVariable("fecha") String Fecha) {
		
    	List<RegistroConsulta> resultadoConsulta = service.consultarListado(Fecha);
    	
		return resultadoConsulta;
	}
}
