package com.clinica.consultas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clinica.consultas.dto.InfoMedicoDTO;

@FeignClient("medicos")
public interface MedicoClient {

	@RequestMapping(method = RequestMethod.GET, path = "/medicos/{cod}")
	public InfoMedicoDTO buscaMedico(@PathVariable String cod);
	
}
