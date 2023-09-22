package com.projeto.hosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.hosp.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
