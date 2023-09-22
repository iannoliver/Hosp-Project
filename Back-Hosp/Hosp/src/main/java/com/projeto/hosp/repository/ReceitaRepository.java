package com.projeto.hosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.hosp.domain.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
