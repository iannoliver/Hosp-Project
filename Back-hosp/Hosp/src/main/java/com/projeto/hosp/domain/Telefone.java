package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtelefone;
	
	@Column(nullable = false)
	private String ddd;
	
	@Column(nullable = false, unique = true)
	private String numero;
	
	@JoinColumn(name = "idmedico")
	private Integer idmedico;
	
	@JoinColumn(name = "idpaciente")
	private Integer idpaciente;

	public Telefone() {
	}

	public Telefone(Integer idtelefone, String ddd, String numero, Integer idmedico, Integer idpaciente) {
		this.idtelefone = idtelefone;
		this.ddd = ddd;
		this.numero = numero;
		this.idmedico = idmedico;
		this.idpaciente = idpaciente;
	}

	public Integer getIdtelefone() {
		return idtelefone;
	}

	public void setIdtelefone(Integer idtelefone) {
		this.idtelefone = idtelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public Integer getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}
	
	
}
