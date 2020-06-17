package com.clinica.consultas.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.clinica.consultas.dto.ConsultaDTO;

import javassist.tools.rmi.ObjectNotFoundException;

public interface ConsultaService {

	public Page<ConsultaDTO> consultas(Pageable pageable);
	
	public ConsultaDTO findByCod(String cod) throws ObjectNotFoundException;
	
	public ConsultaDTO marcaConsulta(ConsultaDTO consultaDTO);
	
	public void cancelaConsulta(String cod); 
	
}
