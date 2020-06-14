package com.clinica.pacientes.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "PACIENTE")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String cod;
	
	private String name;
	
	@Column(unique = true)
	private String cpf;
	
	private LocalDate born;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	public Paciente() {}

	public Paciente(String cod, String name, String cpf, LocalDate born, Sexo sexo) {
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
