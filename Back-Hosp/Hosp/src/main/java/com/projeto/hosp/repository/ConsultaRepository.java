package com.projeto.hosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.hosp.domain.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
