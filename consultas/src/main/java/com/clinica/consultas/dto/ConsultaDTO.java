package com.clinica.consultas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.clinica.consultas.model.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"cod", "data", "local", "paciente", "info_paciente", "medico", "info_medico", "observacao"})
public class ConsultaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cod;

	@JsonFormat(pattern = "dd/MM/yyyy:HH:mm")
	private LocalDateTime data;
	
	@JsonProperty("local")
	private Endereco endereco;
	
	@JsonProperty(value = "medico")
	private String codMedico;
	
	@JsonProperty("paciente")
	private String codPaciente;

	@JsonProperty(value = "info_medico", access = Access.READ_ONLY)
	private InfoMedicoDTO infoMedicoDTO;
	
	@JsonProperty(value = "info_paciente", access = Access.READ_ONLY)
	private InfoPacienteDTO infoPacienteDTO; 
	
	private String observacoes;

	public ConsultaDTO() {}
	
	public ConsultaDTO(String cod, LocalDateTime data, Endereco endereco, String codMedico, String codPaciente,
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

	public void setCodMedico(String codMedico) {
		this.codMedico = codMedico;
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

	public InfoMedicoDTO getInfoMedicoDTO() {
		return infoMedicoDTO;
	}

	public void setInfoMedicoDTO(InfoMedicoDTO infoMedicoDTO) {
		this.infoMedicoDTO = infoMedicoDTO;
	}

	public InfoPacienteDTO getInfoPacienteDTO() {
		return infoPacienteDTO;
	}

	public void setInfoPacienteDTO(InfoPacienteDTO infoPacienteDTO) {
		this.infoPacienteDTO = infoPacienteDTO;
	}
	
}
