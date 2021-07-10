package com.gye.test.service.contrato;

import java.util.List;

import com.gye.test.model.RegistroConsulta;

public interface IRegistroConsultaService {
	 public String consultarEdad(String Nombre) ;
	  
	 	
	  public List<RegistroConsulta> consultarListado(String Fecha) ;
}
