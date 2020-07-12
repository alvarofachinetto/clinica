package com.clinica.medicos.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Especialidade implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("especialidade")
	private String nome;

	public Especialidade() {}

	public Especialidade(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
