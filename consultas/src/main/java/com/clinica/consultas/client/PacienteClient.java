package com.clinica.consultas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clinica.consultas.dto.InfoPacienteDTO;

@FeignClient("paciente")
public interface PacienteClient {

	@RequestMapping(method = RequestMethod.GET, path = "/pacientes/{cod}")
	public InfoPacienteDTO buscarPaciente(@PathVariable String cod);
	
}
