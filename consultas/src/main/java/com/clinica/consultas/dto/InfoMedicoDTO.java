package com.clinica.consultas.dto;

import java.io.Serializable;

public class InfoMedicoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;

	private String telefone;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telfone) {
		this.telefone = telfone;
	}	
	
	
}
