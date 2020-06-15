package com.clinica.medicos.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.clinica.medicos.model.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cod;
	
	private String nome;
	
	private String crm;
	
	private String telefone;
	
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataContratacao;
	
	private List<Especialidade> especialidades;

	public MedicoDTO() {}
	
	public MedicoDTO(String cod, String nome, String crm, String telefone, String email, LocalDate dataContratacao,
			List<Especialidade> especialidades) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.email = email;
		this.dataContratacao = dataContratacao;
		this.especialidades = especialidades;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

}
