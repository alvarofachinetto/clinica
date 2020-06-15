package com.clinica.medicos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Especialidade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private String cod;
	
	@JsonProperty("especialidade")
	private String nome;
	

	public Especialidade() {}
	
	public Especialidade(String cod, String nome) {
		super();
		this.cod = cod;
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
