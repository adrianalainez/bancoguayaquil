package com.gye.test.repositorio.contrato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gye.test.model.RegistroConsulta;

public interface IRegistroJPA extends JpaRepository<RegistroConsulta, Integer>{

	//List<RegistroConsulta> findBynombreAndfechaconsulta(String nombre, String fecha);
	
}
