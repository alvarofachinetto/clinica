package com.clinica.consultas;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.clinica.consultas.model.Consulta;
import com.clinica.consultas.model.Endereco;
import com.clinica.consultas.repository.ConsultaRepository;
import com.clinica.consultas.repository.EnderecoRepository;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
@EnableEurekaClient
public class ConsultasApplication implements CommandLineRunner{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco = new Endereco(RandomString.make(10), "A", 2, "S", "S");

		enderecoRepository.save(endereco);
		
		List<Consulta> consultas = List.of(new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 9, 15, 14, 30), endereco, 
				"Doutor Jedi", "Uruana dos Santos", "Levar o manto"));

		consultaRepository.saveAll(consultas);
	}

}
