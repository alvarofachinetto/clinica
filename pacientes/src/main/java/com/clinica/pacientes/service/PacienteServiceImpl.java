package com.clinica.pacientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinica.pacientes.convert.ConvertPaciente;
import com.clinica.pacientes.dto.PacienteDTO;
import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.repository.PacienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;
import net.bytebuddy.utility.RandomString;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepo;
	
	@Override
	public Page<PacienteDTO> listarPacientes(Pageable pageable){
		return pacienteRepo.findAll(pageable)
				.map(paciente -> ConvertPaciente.ToPacienteDTO(paciente));
	}

	@Override
	public PacienteDTO cadastraPaciente(PacienteDTO pacienteDTO) {
		if(pacienteRepo.findByCpf(pacienteDTO.getCpf()).isPresent())
			return null;
		
		pacienteDTO.setCod(RandomString.make());
		Paciente paciente = pacienteRepo.save(ConvertPaciente.ToPaciente(pacienteDTO));
		return ConvertPaciente.ToPacienteDTO(paciente);
	}

	@Override
	public PacienteDTO findByCod(String cod) throws ObjectNotFoundException {
		Paciente paciente = pacienteRepo.findById(cod)
				.orElseThrow(() -> new ObjectNotFoundException("Paciente não exixtente"));
		return ConvertPaciente.ToPacienteDTO(paciente);
	}

	@Override
	public PacienteDTO atualizaPaciente(PacienteDTO pacienteDTO) {
		if(pacienteDTO.getCod() != null) {
			Paciente paciente = pacienteRepo.save(ConvertPaciente.ToPaciente(pacienteDTO));
			return ConvertPaciente.ToPacienteDTO(paciente);
		}
		return null;
	}

	@Override
	public void deletaPaciente(PacienteDTO pacienteDTO) {
		pacienteRepo.delete(ConvertPaciente.ToPaciente(pacienteDTO));
	}

}
