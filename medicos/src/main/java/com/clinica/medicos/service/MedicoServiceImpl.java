package com.clinica.medicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinica.medicos.convert.MedicoConvert;
import com.clinica.medicos.dto.MedicoDTO;
import com.clinica.medicos.repository.MedicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;
import net.bytebuddy.utility.RandomString;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public Page<MedicoDTO> listarMedicos(Pageable pageable) {
		return medicoRepository
				.findAll(pageable).map(medico -> MedicoConvert.toMedicoDto(medico));
	}

	@Override
	public MedicoDTO cadastraMedico(MedicoDTO medicoDto) {
		if(medicoRepository.findByCrm(medicoDto.getCrm()).isPresent()) {
			return null;
		}
		medicoDto.setCod(RandomString.make(10));
		return MedicoConvert.toMedicoDto(medicoRepository.save(MedicoConvert.toMedico(medicoDto)));
	}

	@Override
	public MedicoDTO findByCrm(String crm) throws ObjectNotFoundException {
		return medicoRepository.findByCrm(crm)
				.map(medico -> MedicoConvert.toMedicoDto(medico))
				.orElseThrow(() -> new ObjectNotFoundException("medico não encontrado"));
	}

	@Override
	public MedicoDTO atualizaMedico(MedicoDTO medicoDto) {
		if(medicoRepository.findById(medicoDto.getCod()).isPresent()) {
			MedicoConvert.toMedicoDto(medicoRepository.save(MedicoConvert.toMedico(medicoDto)));
		}
		return null;
	}

	@Override
	public void deletaMedico(String cod) {
		medicoRepository.deleteById(cod);
	}

	
}
