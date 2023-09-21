package com.projeto.hosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.hosp.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
