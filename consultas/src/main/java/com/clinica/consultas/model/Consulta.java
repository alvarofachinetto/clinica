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
	
	private String codMedico;
	
	private String codPaciente;
	
	private String observacoes;
	
	public Consulta() {}

	public Consulta(String cod, LocalDateTime data, Endereco endereco, String codMedico, String codPaciente,
			String observacoes) {
		super();
		this.cod = cod;
		this.data = data;
		this.endereco = endereco;
		this.codMedico = codMedico;
		this.codPaciente = codPaciente;
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

	public String getCodMedico() {
		return codMedico;
	}

	public void setCodMedico(String medico) {
		this.codMedico = medico;
	}

	public String getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(String paciente) {
		this.codPaciente = paciente;
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
