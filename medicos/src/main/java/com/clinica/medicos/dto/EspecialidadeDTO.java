package com.clinica.medicos.dto;

import java.io.Serializable;

public class EspecialidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;

	public EspecialidadeDTO() {}
	
	public EspecialidadeDTO(String nome) {
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
