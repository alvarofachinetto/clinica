package com.clinica.consultas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinica.consultas.convert.ConvertConsulta;
import com.clinica.consultas.dto.ConsultaDTO;
import com.clinica.consultas.model.Consulta;
import com.clinica.consultas.repository.ConsultaRepository;
import com.clinica.consultas.repository.EnderecoRepository;

import javassist.tools.rmi.ObjectNotFoundException;
import net.bytebuddy.utility.RandomString;

@Service
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaRepository consultaRepository; 
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Page<ConsultaDTO> consultas(Pageable pageable) {
		return consultaRepository.findAll(pageable)
				.map(consulta -> ConvertConsulta.toConsultaDto(consulta));
	}

	@Override
	public ConsultaDTO findByCod(String cod) throws ObjectNotFoundException {
		Optional<Consulta> consulta = consultaRepository.findById(cod);
		if(consulta.isPresent()) {
			return ConvertConsulta.toConsultaDto(consulta.get());
		}
		return null;
	}

	@Override
	public ConsultaDTO marcaConsulta(ConsultaDTO consultaDTO) {
		if(!consultaRepository.findById(consultaDTO.getCod()).isPresent()) {
			consultaDTO.setCod(RandomString.make(10));
			consultaDTO.getEndereco().setCod(RandomString.make(10));
			enderecoRepository.save(consultaDTO.getEndereco());
			ConvertConsulta.toConsultaDto(consultaRepository.save(ConvertConsulta.toConsulta(consultaDTO)));
		}
		return null;
	}

	@Override
	public void cancelaConsulta(String cod) {
		consultaRepository.deleteById(cod);
	}

}
