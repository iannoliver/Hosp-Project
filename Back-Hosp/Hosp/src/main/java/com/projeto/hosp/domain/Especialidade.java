package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idespecialidade;
	
	@Column(nullable = false)
	private String nomeespecialidade;
	
	public Especialidade() {
	}

	public Especialidade(Integer idespecialidade, String nomeespecialidade) {
		this.idespecialidade = idespecialidade;
		this.nomeespecialidade = nomeespecialidade;
	}

	public Integer getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Integer idespecialidade) {
		this.idespecialidade = idespecialidade;
	}

	public String getNomeespecialidade() {
		return nomeespecialidade;
	}

	public void setNomeespecialidade(String nomeespecialidade) {
		this.nomeespecialidade = nomeespecialidade;
	}
	
	
}
