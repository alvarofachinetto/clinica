package com.clinica.pacientes.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinica.pacientes.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	@Query("SELECT p FROM PACIENTE p where p.name LIKE CONCAT('%', :name, '%')")
	public Page<Paciente> filtraPorNome(@Param("name") String name, Pageable pageable); 
	
	public Optional<Paciente> findByCpf(String cpf);
	
}
