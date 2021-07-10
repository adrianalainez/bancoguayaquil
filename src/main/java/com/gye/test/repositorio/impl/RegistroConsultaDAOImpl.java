package com.gye.test.repositorio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gye.test.model.RegistroConsulta;
import com.gye.test.repositorio.contrato.IRegistroConsultaDAO;
import com.gye.test.repositorio.contrato.IRegistroJPA;

@Repository
public class RegistroConsultaDAOImpl implements IRegistroConsultaDAO{
	
	@Autowired
	IRegistroJPA regDao;

	@Override
	 public void guardarLogs(String nombre, int edad, String consumo, String fecha ) {
		
		RegistroConsulta registro = new RegistroConsulta();
			
			registro.setNombre(nombre);
			registro.setEdad(edad);
			registro.setConsulta(consumo);		
			registro.setFechaConsulta(fecha);
			
			regDao.save(registro);
			
	 }
	  
	@Override
	  public List<RegistroConsulta> consultarListadoFecha(String Fecha){

			
			 List<RegistroConsulta> resultadoconsulta = null;
			 
			 resultadoconsulta = regDao.findAll();
			 
			 List<RegistroConsulta> consulta = resultadoconsulta.stream()
					 .filter (x->x.getFechaConsulta().equals(Fecha)).collect(Collectors.toList());
					
			 return consulta;
	  }
	  
	@Override
	  public RegistroConsulta  consultarNombreLogDia(String nombre, String fecha) {
		  
		  List<RegistroConsulta> resultado = null;
		  
		  resultado = regDao.findAll();
		  
		  for(RegistroConsulta item :resultado) {
			  if(item.getNombre().equals(nombre) && item.getFechaConsulta().equals(fecha)) {
				  return item;
			  }
		  }
		  
		  return null;
	  }
}
