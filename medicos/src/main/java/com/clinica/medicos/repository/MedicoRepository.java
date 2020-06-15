package com.clinica.medicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.medicos.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String>{

	Optional<Medico> findByCrm(String crm);
	
	
}
