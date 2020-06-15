package com.clinica.medicos.convert;

import com.clinica.medicos.dto.MedicoDTO;
import com.clinica.medicos.model.Medico;

public class MedicoConvert {

	public static Medico toMedico(MedicoDTO medicoDto) {
		return new Medico(medicoDto.getCod(), medicoDto.getNome(), medicoDto.getCrm(), medicoDto.getEspecialidades(), 
				medicoDto.getTelefone(), medicoDto.getEmail(), medicoDto.getDataContratacao());
	}
	
	public static MedicoDTO toMedicoDto(Medico medico) {
		return new MedicoDTO(medico.getCod(), medico.getNome(), 
				medico.getCrm(), medico.getTelefone(), medico.getEmail(), medico.getDataContratacao(), medico.getEspecialidades());
	}
}
