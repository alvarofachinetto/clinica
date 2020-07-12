package com.clinica.consultas;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

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
		
		Endereco endereco = new Endereco(RandomString.make(10), "Av Angélica", 2574, "São Paulo", "São Paulo");

		enderecoRepository.save(endereco);

		Consulta consulta1 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 9, 15, 14, 30), endereco, "1", "1", "");
		Consulta consulta2 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 10, 15, 15, 45), endereco, "2", "3", "");
		Consulta consulta3 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 8, 30, 16, 00), endereco, "6", "9", "");
		Consulta consulta4 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 8, 23, 15, 15), endereco, "7", "2", "");
		Consulta consulta5 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 12, 4, 13, 50), endereco, "5", "5", "");
		Consulta consulta6 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2021, 1, 12, 15, 00), endereco, "1", "6", "");
		Consulta consulta7 = new Consulta(RandomString.make(10), 
				LocalDateTime.of(2020, 7, 15, 14, 30), endereco, "8", "3", "");
		
		consultaRepository.saveAll(Arrays.asList(consulta1, consulta2, consulta3, consulta4, consulta5, consulta6, consulta7));
	}

}
