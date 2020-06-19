package com.clinica.medicos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clinica.medicos.dto.MedicoDTO;

import javassist.tools.rmi.ObjectNotFoundException;

public interface MedicoService {

	public Page<MedicoDTO> listarMedicos(Pageable pageable);
	
	public MedicoDTO cadastraMedico(MedicoDTO medicoDto);
	
	public MedicoDTO findByCod(String cod) throws ObjectNotFoundException;
	
	public MedicoDTO atualizaMedico(MedicoDTO medicoDto);
	
	public void deletaMedico(String cod);
	
}
