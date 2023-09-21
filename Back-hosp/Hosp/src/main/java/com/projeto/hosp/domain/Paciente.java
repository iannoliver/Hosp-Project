package com.projeto.hosp.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpaciente;
	
	@Column(nullable = false)
	private String nomepaciente;
	
	@Column(nullable = false)
	private Date dtnascimento;
	
	@Column(nullable = false, unique=true)
	private String cpfpaciente;
	
	@Column(nullable = false, unique=true)
	private String rgpaciente;
	
	@Column(nullable = false, unique=true)
	private String emailpaciente;
	
	@JoinColumn(name = "idconvenio")
	private Integer idconvenio;

	public Paciente() {
	}

	public Paciente(Integer idpaciente, String nomepaciente, Date dtnascimento, String cpfpaciente, String rgpaciente,
			String emailpaciente, Integer idconvenio) {
		this.idpaciente = idpaciente;
		this.nomepaciente = nomepaciente;
		this.dtnascimento = dtnascimento;
		this.cpfpaciente = cpfpaciente;
		this.rgpaciente = rgpaciente;
		this.emailpaciente = emailpaciente;
		this.idconvenio = idconvenio;
	}

	public Integer getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNomepaciente() {
		return nomepaciente;
	}

	public void setNomepaciente(String nomepaciente) {
		this.nomepaciente = nomepaciente;
	}

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public String getCpfpaciente() {
		return cpfpaciente;
	}

	public void setCpfpaciente(String cpfpaciente) {
		this.cpfpaciente = cpfpaciente;
	}

	public String getRgpaciente() {
		return rgpaciente;
	}

	public void setRgpaciente(String rgpaciente) {
		this.rgpaciente = rgpaciente;
	}

	public String getEmailpaciente() {
		return emailpaciente;
	}

	public void setEmailpaciente(String emailpaciente) {
		this.emailpaciente = emailpaciente;
	}

	public Integer getIdconvenio() {
		return idconvenio;
	}

	public void setIdconvenio(Integer idconvenio) {
		this.idconvenio = idconvenio;
	}

	
}
