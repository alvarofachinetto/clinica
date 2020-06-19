package com.clinica.pacientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.pacientes.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String>{

	public Optional<Paciente> findByCpf(String cpf);
}
