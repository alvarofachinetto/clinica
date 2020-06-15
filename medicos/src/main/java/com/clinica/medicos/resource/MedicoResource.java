package com.clinica.medicos.resource;

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

import com.clinica.medicos.dto.MedicoDTO;
import com.clinica.medicos.service.MedicoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<Page<MedicoDTO>> listaDeMedicos(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit){
	
		Pageable pageable = PageRequest.of(page, limit);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(medicoService.listarMedicos(pageable));
	}
	
	@GetMapping("/{crm}")
	public ResponseEntity<MedicoDTO> buscarPorCPF(@PathVariable("crm") String crm) throws ObjectNotFoundException{
		return ResponseEntity.status(HttpStatus.OK)
				.body(medicoService.findByCrm(crm));
	}
	
	@PostMapping
	public ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoDTO medicoDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(medicoService.cadastraMedico(medicoDTO));
	}
	
	@PutMapping
	public ResponseEntity<MedicoDTO> atualizaMedico(@RequestBody MedicoDTO medicoDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(medicoService.atualizaMedico(medicoDTO));
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deletaMedico(@PathVariable("cod") String cod){
		medicoService.deletaMedico(cod);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.build();
	}
	
}
