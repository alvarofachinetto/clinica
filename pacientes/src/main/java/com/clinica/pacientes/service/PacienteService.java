package com.clinica.pacientes.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clinica.pacientes.dto.PacienteDTO;

import javassist.tools.rmi.ObjectNotFoundException;

public interface PacienteService {

	public Page<PacienteDTO> listarPacientes(Pageable pageable);
	
	public PacienteDTO cadastraPaciente(PacienteDTO pacienteDTO);
	
	public PacienteDTO findByCod (String cod) throws ObjectNotFoundException;
	
	public PacienteDTO atualizaPaciente(PacienteDTO pacienteDTO);
	
	public void deletaPaciente(PacienteDTO pacienteDTO);
	
}
