package com.clinica.consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.consultas.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
