package com.clinica.pacientes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.model.Sexo;
import com.clinica.pacientes.repository.PacienteRepository;

@SpringBootApplication
@EnableEurekaClient
public class PacientesApplication implements CommandLineRunner{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PacientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Paciente> pacientes = List.of(
			new Paciente("1", "Catarina Ramos", "458.896.694-97", LocalDate.of(1996, 05, 15), Sexo.FEMININO),
			new Paciente("2", "João da Silva Frenes", "154.964.744-12", LocalDate.of(1992, 01, 8), Sexo.MASCULINO),
			new Paciente("3", "Ednaldo Denver", "964.227.841-98", LocalDate.of(1983, 10, 29), Sexo.MASCULINO),
			new Paciente("4", "Dinner Freire", "658.941.520-78", LocalDate.of(1975, 11, 12), Sexo.MASCULINO),
			new Paciente("5", "Cléudia Oliveira", "417.367.777-10", LocalDate.of(1998, 8, 18), Sexo.MASCULINO),
			new Paciente("6", "Bianca Hyraki", "225.746.365-71", LocalDate.of(2000, 07, 18), Sexo.FEMININO),
			new Paciente("7", "Cristiano Clau", "974.124.222-34", LocalDate.of(1973, 04, 01), Sexo.MASCULINO),
			new Paciente("8", "Maria Chivas", "111.111.111-11", LocalDate.of(1986, 05, 15), Sexo.FEMININO),
			new Paciente("9", "Renato Cavalheiro", "222.222.222-22", LocalDate.of(1988, 05, 30), Sexo.MASCULINO),
			new Paciente("10", "Osvaldo Luis", "333.333.222-55", LocalDate.of(1983, 7, 22), Sexo.MASCULINO),
			new Paciente("11", "Nicolas Santos", "444.444.444-44", LocalDate.of(1975, 9, 25), Sexo.MASCULINO),
			new Paciente("12", "Katarina Niang", "555.555.555-55", LocalDate.of(1992, 03, 20), Sexo.FEMININO),
			new Paciente("13", "Cinthia Reis", "777.777.777-77", LocalDate.of(1976, 02, 27), Sexo.FEMININO),
			new Paciente("14", "Kurino Ramos", "888.888.888-88", LocalDate.of(1998, 12, 31), Sexo.MASCULINO)
		); 
		
		pacientes.forEach(paciente -> pacienteRepository.save(paciente));
	}

}
