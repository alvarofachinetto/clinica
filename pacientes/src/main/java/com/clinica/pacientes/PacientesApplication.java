package com.clinica.pacientes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.model.Sexo;
import com.clinica.pacientes.repository.PacienteRepository;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class PacientesApplication implements CommandLineRunner{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PacientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Paciente> pacientes = List.of(
			new Paciente(RandomString.make(15), "Catarina Ramos", "458.896.694-97", LocalDate.of(1996, 05, 15), Sexo.FEMININO),
			new Paciente(RandomString.make(15), "João da Silva Frenes", "154.964.744-12", LocalDate.of(1992, 01, 8), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Ednaldo Denver", "964.227.841-98", LocalDate.of(1983, 10, 29), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Dinner Freire", "658.941.520-78", LocalDate.of(1975, 11, 12), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Cléudia Oliveira", "417.367.777-10", LocalDate.of(1993, 8, 18), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Bianca Hyraki", "225.746.365-71", LocalDate.of(1996, 07, 18), Sexo.FEMININO),
			new Paciente(RandomString.make(15), "Cristiano Clau", "974.124.222-34", LocalDate.of(1996, 04, 01), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Maria Chivas", "111.111.111-11", LocalDate.of(1996, 05, 15), Sexo.FEMININO),
			new Paciente(RandomString.make(15), "Renato Cavalheiro", "222.222.222-22", LocalDate.of(1996, 05, 30), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Osvaldo Luis", "333.333.222-55", LocalDate.of(1996, 7, 22), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Nicolas Santos", "444.444.444-44", LocalDate.of(1996, 9, 25), Sexo.MASCULINO),
			new Paciente(RandomString.make(15), "Katarina Niang", "555.555.555-55", LocalDate.of(1996, 03, 20), Sexo.FEMININO),
			new Paciente(RandomString.make(15), "Cinthia Reis", "777.777.777-77", LocalDate.of(1996, 02, 27), Sexo.FEMININO),
			new Paciente(RandomString.make(15), "Kurino Ramos", "888.888.888-88", LocalDate.of(1996, 12, 31), Sexo.MASCULINO)
		); 
		
		pacientes.forEach(paciente -> pacienteRepository.save(paciente));
	}

}
