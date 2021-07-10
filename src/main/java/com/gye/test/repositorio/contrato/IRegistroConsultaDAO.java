package com.gye.test.repositorio.contrato;

import java.util.List;

import com.gye.test.model.*;

public interface IRegistroConsultaDAO {
	 public void guardarLogs(String nombre, int edad, String consumo, String fecha );
	  
	  public List<RegistroConsulta> consultarListadoFecha(String Fecha);
	  
	  public RegistroConsulta  consultarNombreLogDia(String Fecha, String nombre);
}
