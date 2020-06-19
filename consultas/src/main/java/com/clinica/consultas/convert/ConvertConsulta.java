package com.clinica.consultas.convert;

import com.clinica.consultas.dto.ConsultaDTO;
import com.clinica.consultas.model.Consulta;

public class ConvertConsulta {

	public static Consulta toConsulta(ConsultaDTO consultaDTO) {
		return new Consulta(consultaDTO.getCod(), consultaDTO.getData(), consultaDTO.getEndereco(), 
				consultaDTO.getCodMedico(), consultaDTO.getCodPaciente(), consultaDTO.getObservacoes());
	}
	
	public static ConsultaDTO toConsultaDto(Consulta consulta) {
		return new ConsultaDTO(consulta.getCod(), consulta.getData(), consulta.getEndereco(), 
				consulta.getCodMedico(), consulta.getCodPaciente(), consulta.getObservacoes());
	}
	
}
