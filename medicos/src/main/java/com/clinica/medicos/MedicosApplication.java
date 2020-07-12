package com.clinica.medicos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.clinica.medicos.model.Especialidade;
import com.clinica.medicos.model.Medico;
import com.clinica.medicos.repository.MedicoRepository;

@SpringBootApplication
@EnableEurekaClient
public class MedicosApplication implements CommandLineRunner{

	@Autowired
	private MedicoRepository medicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MedicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
			Especialidade e1 = new Especialidade("Dermatologia");
			Especialidade e2 =  new Especialidade("Ortopedia");
			Especialidade e3 =  new Especialidade("Pediatra");
			Especialidade e4 =  new Especialidade("Psiquiatra");
			Especialidade e5 =  new Especialidade("Oftalmologia");
			Especialidade e6 =  new Especialidade("Anestesiologia");
			Especialidade e7 =  new Especialidade("Urologia");
			Especialidade e8 =  new Especialidade("Radiologia");
		
			
			
			Medico m1 = new Medico("1", "Carlos Souza", "0000000", Set.of(e1, e5), "3964-2548", "ruancardoso@clinica.com.br", LocalDate.of(2011, 05, 16));
			Medico m2 =	new Medico("2", "Silvia de Paula", "1111111", Set.of(e4, e6), "3964-5145", "silvia.paula@clinica.com.br", LocalDate.of(2013, 8, 23));
			Medico m3 =	new Medico("3", "Adão Matusalem", "2222222", Set.of(e3), "3964-4187", "adaomatus@clinica.com.br", LocalDate.of(2001, 04, 19));
			Medico m4 =	new Medico("4", "Geovanna Di Matteo", "3333333", Set.of(e8, e7), "3964-8888", "geovannamateo@clinica.com.br", LocalDate.of(2015, 03, 10));
			Medico m5 =	new Medico("5", "João Pereira", "4444444", Set.of(e5, e2), "3964-3524", "joaopereira@clinica.com.br", LocalDate.of(2018, 9, 26));
			Medico m6 =	new Medico("6", "Yago Santana", "5555555", Set.of(e1, e8), "3964-7841", "yagosantana@clinica.com.br", LocalDate.of(2008, 12, 05));
			Medico m7 =	new Medico("7", "Matheus da Silva", "6666666", Set.of(e7, e3), "3964-3523", "matheussilva@clinica.com.br", LocalDate.of(2004, 10, 24));
			Medico m8 =	new Medico("8", "Taís Edmundo", "7777777", Set.of(e8), "3964-2451", "taisedmundo@clinica.com.br", LocalDate.of(2009, 10, 30));
		
			
		medicoRepository.saveAll(List.of(m1, m2, m3, m4, m5, m6, m7, m8));		
		
	}

}
