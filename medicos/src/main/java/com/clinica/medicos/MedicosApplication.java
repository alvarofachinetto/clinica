package com.clinica.medicos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.clinica.medicos.model.Especialidade;
import com.clinica.medicos.model.Medico;
import com.clinica.medicos.repository.EspeciaidadeRepository;
import com.clinica.medicos.repository.MedicoRepository;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
@EnableEurekaClient
public class MedicosApplication implements CommandLineRunner{

	@Autowired
	private EspeciaidadeRepository especiaidadeRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MedicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Especialidade> especialidades = List.of(
			new Especialidade(RandomString.make(5), "Dermatologia"),
			new Especialidade(RandomString.make(5), "Ortopedia"),
			new Especialidade(RandomString.make(5), "Pediatra")
		);
		
		Medico medico = 
			new Medico("1", "Carlos Souza", "0000000", especialidades, 
					"3964-2548", "ruancardoso@clinica.com.br", LocalDate.of(2011, 05, 16));
		especiaidadeRepository.saveAll(especialidades);
		medicoRepository.save(medico);
		
	}

}
