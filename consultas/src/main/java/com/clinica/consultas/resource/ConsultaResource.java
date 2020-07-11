package com.clinica.consultas.resource;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.consultas.client.MedicoClient;
import com.clinica.consultas.client.PacienteClient;
import com.clinica.consultas.dto.ConsultaDTO;
import com.clinica.consultas.dto.InfoMedicoDTO;
import com.clinica.consultas.dto.InfoPacienteDTO;
import com.clinica.consultas.service.ConsultaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/consultas")
public class ConsultaResource {

	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private MedicoClient medicoClient;
	
	@Autowired
	private PacienteClient pacienteClient;
	
	@GetMapping
	public ResponseEntity<Page<ConsultaDTO>> consultas(
		@RequestParam("page") int page,
		@RequestParam("limit") int limit){
		Pageable pageable = PageRequest.of(page, limit);
		
		Page<ConsultaDTO> consultas = consultaService.consultas(pageable).map(consulta -> {
			consulta.setInfoMedicoDTO(requisicaoMedico(consulta));
			consulta.setInfoPacienteDTO(requisicaoPaciente(consulta));
			return consulta;
		});
		
		return ResponseEntity.ok().body(consultas);
	}
	
	@GetMapping("/{cod}")
	public ResponseEntity<ConsultaDTO> findByCod(@PathVariable String cod) throws ObjectNotFoundException{
		ConsultaDTO consultaDTO = consultaService.findByCod(cod);
		consultaDTO.setInfoMedicoDTO(requisicaoMedico(consultaDTO));
		consultaDTO.setInfoPacienteDTO(requisicaoPaciente(consultaDTO));
		
		return ResponseEntity.ok()
				.body(consultaDTO);
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> marcaConsulta(@RequestBody ConsultaDTO consultaDTO){
		if(requisicaoMedico(consultaDTO) != null && requisicaoPaciente(consultaDTO) != null)
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(consultaService.marcaConsulta(consultaDTO));
		
		return ResponseEntity.badRequest().build();
		
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> cancelaConsulta(@PathVariable("cod") String cod){
		consultaService.cancelaConsulta(cod);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.build();
	}
	
	private InfoMedicoDTO requisicaoMedico(ConsultaDTO consultaDTO) {
		return medicoClient.buscaMedico(consultaDTO.getCodMedico());
	}
	
	private InfoPacienteDTO requisicaoPaciente(ConsultaDTO consultaDTO) {
		return pacienteClient.buscarPaciente(consultaDTO.getCodPaciente());
	}
}
