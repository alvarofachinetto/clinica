package com.clinica.medicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.medicos.model.Especialidade;

@Repository
public interface EspeciaidadeRepository extends JpaRepository<Especialidade, String>{

}
