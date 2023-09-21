package com.projeto.hosp.domain;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Convenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idconvenio;
	
	@Column(nullable = false)
	private String nomeconvenio;
	
	@Column(nullable = false, unique=true)
	private String cnpjconvenio;
	
	@Column(nullable = false)
	private Time tempocarencia;

	public Convenio() {
	}

	public Convenio(Integer idconvenio, String nomeconvenio, String cnpjconvenio, Time tempocarencia) {
		this.idconvenio = idconvenio;
		this.nomeconvenio = nomeconvenio;
		this.cnpjconvenio = cnpjconvenio;
		this.tempocarencia = tempocarencia;
	}

	public Integer getIdconvenio() {
		return idconvenio;
	}

	public void setIdconvenio(Integer idconvenio) {
		this.idconvenio = idconvenio;
	}

	public String getNomeconvenio() {
		return nomeconvenio;
	}

	public void setNomeconvenio(String nomeconvenio) {
		this.nomeconvenio = nomeconvenio;
	}

	public String getCnpjconvenio() {
		return cnpjconvenio;
	}

	public void setCnpjconvenio(String cnpjconvenio) {
		this.cnpjconvenio = cnpjconvenio;
	}

	public Time getTempocarencia() {
		return tempocarencia;
	}

	public void setTempocarencia(Time tempocarencia) {
		this.tempocarencia = tempocarencia;
	}

	
}
