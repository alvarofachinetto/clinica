package com.clinica.medicos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String cod;
	
	private String nome;
	
	private String crm;

	private String telefone;
	
	private String email;

	private LocalDate dataContratacao;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Especialidade> especialidades;
	
	
	public Medico() {}
	
	
	
	public Medico(String cod, String nome, String crm, List<Especialidade> especialidades, String telefone, String email,
			LocalDate dataContratacao) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.crm = crm;
		this.especialidades = especialidades;
		this.telefone = telefone;
		this.email = email;
		this.dataContratacao = dataContratacao;
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

	public List<Especialidade> getEspecialidades() {
		return especialidades;
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
	
	
}
