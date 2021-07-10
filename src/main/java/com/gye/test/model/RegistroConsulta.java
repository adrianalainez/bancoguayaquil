package com.gye.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistroConsulta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private Integer id;
	@Column
	private String nombre;
	
	@Column
	private int edad; 
	
	@Column
	private String fechaConsulta;
	
	@Column
	private String consulta;

	
	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad; 
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}

