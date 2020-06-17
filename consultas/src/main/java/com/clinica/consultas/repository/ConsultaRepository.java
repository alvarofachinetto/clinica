package com.clinica.consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.consultas.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, String>{

}
