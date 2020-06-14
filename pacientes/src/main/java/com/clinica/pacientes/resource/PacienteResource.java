package com.clinica.pacientes.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.pacientes.dto.PacienteDTO;
import com.clinica.pacientes.service.PacienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<Page<PacienteDTO>> listaDePacientes(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit){
	
		Pageable pageable = PageRequest.of(page, limit);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(pacienteService.listarPacientes(pageable));
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<PacienteDTO> buscarPorCPF(@PathVariable("cpf") String cpf) throws ObjectNotFoundException{
		return ResponseEntity.status(HttpStatus.OK)
				.body(pacienteService.findByCpf(cpf));
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pacienteService.cadastraPaciente(pacienteDTO));
	}
	
	@PutMapping
	public ResponseEntity<PacienteDTO> atualizaPaciente(@RequestBody PacienteDTO pacienteDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pacienteService.atualizaPaciente(pacienteDTO));
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletaPaciente(@Valid @RequestBody PacienteDTO pacienteDTO){
		pacienteService.deletaPaciente(pacienteDTO);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.build();
	}
	
}
