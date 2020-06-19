package com.clinica.consultas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InfoPacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate born; 
	
	private String sexo;

	public InfoPacienteDTO() {}
	
	public InfoPacienteDTO(String name, LocalDate born, String sexo) {
		super();
		this.name = name;
		this.born = born;
		this.sexo = sexo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBorn() {
		return born;
	}

	public void setIdade(LocalDate born) {
		this.born = born;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
