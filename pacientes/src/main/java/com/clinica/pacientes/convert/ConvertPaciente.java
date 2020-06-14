package com.clinica.pacientes.convert;

import com.clinica.pacientes.dto.PacienteDTO;
import com.clinica.pacientes.model.Paciente;

public class ConvertPaciente {

	public static PacienteDTO ToPacienteDTO(Paciente paciente) {
		PacienteDTO pacienteDTO = 
				new PacienteDTO(paciente.getCod(), paciente.getName(), paciente.getCpf(), paciente.getBorn(), paciente.getSexo());
		return pacienteDTO;
	}
	
	public static Paciente ToPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = 
				new Paciente(pacienteDTO.getCod(), pacienteDTO.getName(), pacienteDTO.getCpf(), pacienteDTO.getBorn(), pacienteDTO.getSexo());
		return paciente;
	}
	
}
