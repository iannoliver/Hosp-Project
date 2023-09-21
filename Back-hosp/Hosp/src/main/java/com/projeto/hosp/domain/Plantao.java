package com.projeto.hosp.domain;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Plantao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idplantao;
	
	@Column(nullable = false)
	private Date dtplantao;
	
	@Column(nullable = false)
	private Time horaplantao;
	
	@JoinColumn(name = "idinternacao")
	private Integer idinternacao;
	
	@JoinColumn(name = "idenfermeira")
	private Integer idenfermeira;

	public Plantao() {
	}

	public Plantao(Integer idplantao, Date dtplantao, Time horaplantao, Integer idinternacao, Integer idenfermeira) {
		this.idplantao = idplantao;
		this.dtplantao = dtplantao;
		this.horaplantao = horaplantao;
		this.idinternacao = idinternacao;
		this.idenfermeira = idenfermeira;
	}

	public Integer getIdplantao() {
		return idplantao;
	}

	public void setIdplantao(Integer idplantao) {
		this.idplantao = idplantao;
	}

	public Date getDtplantao() {
		return dtplantao;
	}

	public void setDtplantao(Date dtplantao) {
		this.dtplantao = dtplantao;
	}

	public Time getHoraplantao() {
		return horaplantao;
	}

	public void setHoraplantao(Time horaplantao) {
		this.horaplantao = horaplantao;
	}

	public Integer getIdinternacao() {
		return idinternacao;
	}

	public void setIdinternacao(Integer idinternacao) {
		this.idinternacao = idinternacao;
	}

	public Integer getIdenfermeira() {
		return idenfermeira;
	}

	public void setIdenfermeira(Integer idenfermeira) {
		this.idenfermeira = idenfermeira;
	}
	
	
}
