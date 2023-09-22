package com.projeto.hosp.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Internacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idinternacao;
	
	@Column(nullable = false)
	private Date dataentrada;
	
	@Column(nullable = false)
	private Date dataprevalta;
	
	@Column(nullable = false)
	private Date dataefetalta;
	
	@Column(nullable = false)
	private String descprocedimentos;
	
	@JoinColumn(name = "idpaciente")
	private Integer idpaciente;
	
	@JoinColumn(name = "idmedico")
	private Integer idmedico;
	
	@JoinColumn(name = "idquarto")
	private Integer idquarto;

	public Internacao() {
	}

	public Internacao(Integer idinternacao, Date dataentrada, Date dataprevalta, Date dataefetalta,
			String descprocedimentos, Integer idpaciente, Integer idmedico, Integer idquarto) {
		this.idinternacao = idinternacao;
		this.dataentrada = dataentrada;
		this.dataprevalta = dataprevalta;
		this.dataefetalta = dataefetalta;
		this.descprocedimentos = descprocedimentos;
		this.idpaciente = idpaciente;
		this.idmedico = idmedico;
		this.idquarto = idquarto;
	}

	public Integer getIdinternacao() {
		return idinternacao;
	}

	public void setIdinternacao(Integer idinternacao) {
		this.idinternacao = idinternacao;
	}

	public Date getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}

	public Date getDataprevalta() {
		return dataprevalta;
	}

	public void setDataprevalta(Date dataprevalta) {
		this.dataprevalta = dataprevalta;
	}

	public Date getDataefetalta() {
		return dataefetalta;
	}

	public void setDataefetalta(Date dataefetalta) {
		this.dataefetalta = dataefetalta;
	}

	public String getDescprocedimentos() {
		return descprocedimentos;
	}

	public void setDescprocedimentos(String descprocedimentos) {
		this.descprocedimentos = descprocedimentos;
	}

	public Integer getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public Integer getIdquarto() {
		return idquarto;
	}

	public void setIdquarto(Integer idquarto) {
		this.idquarto = idquarto;
	}
	
	
}
