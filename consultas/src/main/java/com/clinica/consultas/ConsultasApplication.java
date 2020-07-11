package com.clinica.consultas;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.consultas.convert.ConvertConsulta;
import com.clinica.consultas.dto.ConsultaDTO;
import com.clinica.consultas.model.Consulta;
import com.clinica.consultas.model.Endereco;
import com.clinica.consultas.repository.ConsultaRepository;
import com.clinica.consultas.repository.EnderecoRepository;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
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

		ConsultaDTO consultaDTO = new ConsultaDTO(RandomString.make(10), 
				LocalDateTime.of(2020, 9, 15, 14, 30), endereco, "1", "1", "Levar o manto");
		
		Consulta consultas = ConvertConsulta.toConsulta(consultaDTO);

		consultaRepository.save(consultas);
	}

}
