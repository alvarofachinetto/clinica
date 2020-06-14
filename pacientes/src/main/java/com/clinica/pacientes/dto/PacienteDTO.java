package com.clinica.pacientes.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.clinica.pacientes.model.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod;

	private String name;
	
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate born;
	
	private Sexo sexo;
	
	public PacienteDTO() {}

	public PacienteDTO(String cod, String name,String cpf, LocalDate born, Sexo sexo) {
		super();
		this.cod = cod;
		this.name = name;
		this.cpf = cpf;
		this.born = born;
		this.sexo = sexo;
	}

	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getBorn() {
		return born;
	}
	public void setBorn(LocalDate born) {
		this.born = born;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}
