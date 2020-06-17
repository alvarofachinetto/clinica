package com.clinica.consultas.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Consulta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String cod;
	
	private LocalDateTime data;
	
	@OneToOne
	private Endereco endereco;
	
	private String medico;
	
	private String paciente;
	
	private String observacoes;
	
	public Consulta() {}

	public Consulta(String cod, LocalDateTime data, Endereco endereco, String medico, String paciente,
			String observacoes) {
		super();
		this.cod = cod;
		this.data = data;
		this.endereco = endereco;
		this.medico = medico;
		this.paciente = paciente;
		this.observacoes = observacoes;
	}




	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
}
