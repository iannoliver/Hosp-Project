package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmedico;
	
	@Column(nullable = false)
	private String nomemed;
	
	@Column(nullable = false, unique=true)
	private String cpf;
	
	@Column(nullable = false, unique=true)
	private String crm;
	
	@Column(nullable = false, unique=true)
	private String emailmed;
	
	@Column(nullable = false)
	private String cargo;
	
	@JoinColumn(name = "idespecialidade", nullable = false)
	private Integer idespecialidade;

	public Medico() {
	}

	public Medico(Integer idmedico, String nomemed, String cpf, String crm, String emailmed, String cargo,
			Integer idespecialidade) {
		this.idmedico = idmedico;
		this.nomemed = nomemed;
		this.cpf = cpf;
		this.crm = crm;
		this.emailmed = emailmed;
		this.cargo = cargo;
		this.idespecialidade = idespecialidade;
	}

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public String getNomemed() {
		return nomemed;
	}

	public void setNomemed(String nomemed) {
		this.nomemed = nomemed;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEmailmed() {
		return emailmed;
	}

	public void setEmailmed(String emailmed) {
		this.emailmed = emailmed;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Integer idespecialidade) {
		this.idespecialidade = idespecialidade;
	}
	

}
