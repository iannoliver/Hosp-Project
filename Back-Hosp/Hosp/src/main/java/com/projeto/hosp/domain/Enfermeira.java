package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enfermeira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idenfermeira;
	
	@Column(nullable = false)
	private String nomeenfermeira;
	
	@Column(nullable = false, unique=true)
	private String cpfenfermeira;
	
	@Column(nullable = false, unique=true)
	private String coren;

	public Enfermeira() {
	}

	public Enfermeira(Integer idenfermeira, String nomeenfermeira, String cpfenfermeira, String coren) {
		this.idenfermeira = idenfermeira;
		this.nomeenfermeira = nomeenfermeira;
		this.cpfenfermeira = cpfenfermeira;
		this.coren = coren;
	}

	public Integer getIdenfermeira() {
		return idenfermeira;
	}

	public void setIdenfermeira(Integer idenfermeira) {
		this.idenfermeira = idenfermeira;
	}

	public String getNomeenfermeira() {
		return nomeenfermeira;
	}

	public void setNomeenfermeira(String nomeenfermeira) {
		this.nomeenfermeira = nomeenfermeira;
	}

	public String getCpfenfermeira() {
		return cpfenfermeira;
	}

	public void setCpfenfermeira(String cpfenfermeira) {
		this.cpfenfermeira = cpfenfermeira;
	}

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}
	
	
}
