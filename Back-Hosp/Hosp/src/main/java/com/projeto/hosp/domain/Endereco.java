package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idendereco;
	
	@Column(nullable = false)
	private String log;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = true)
	private String complemento;
	
	@Column(nullable = true)
	private String referencia;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	@JoinColumn(name = "idmedico")
	private Integer idmedico;
	
	@JoinColumn(name = "idpaciente")
	private Integer idpaciente;

	public Endereco() {
	}

	public Endereco(Integer idendereco, String log, String cep, String numero, String complemento, String referencia,
			String bairro, String cidade, String estado, Integer idmedico, Integer idepaciente) {
		this.idendereco = idendereco;
		this.log = log;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.referencia = referencia;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.idmedico = idmedico;
		this.idpaciente = idepaciente;
	}

	public Integer getIdendereco() {
		return idendereco;
	}

	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public Integer getIdepaciente() {
		return idpaciente;
	}

	public void setIdepaciente(Integer idepaciente) {
		this.idpaciente = idepaciente;
	}
	
	
}
