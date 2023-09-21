package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idreceita;
	
	@Column(nullable = false)
	private String medicamento;
	
	@Column(nullable = false)
	private Double qtdmedicamento;
	
	@Column(nullable = false)
	private String instrucaouso;
	
	@JoinColumn(name = "idconsulta")
	private Integer idconsulta;

	public Receita() {
	}

	public Receita(Integer idreceita, String medicamento, Double qtdmedicamento, String instrucaouso,
			Integer idconsulta) {
		this.idreceita = idreceita;
		this.medicamento = medicamento;
		this.qtdmedicamento = qtdmedicamento;
		this.instrucaouso = instrucaouso;
		this.idconsulta = idconsulta;
	}

	public Integer getIdreceita() {
		return idreceita;
	}

	public void setIdreceita(Integer idreceita) {
		this.idreceita = idreceita;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public Double getQtdmedicamento() {
		return qtdmedicamento;
	}

	public void setQtdmedicamento(Double qtdmedicamento) {
		this.qtdmedicamento = qtdmedicamento;
	}

	public String getInstrucaouso() {
		return instrucaouso;
	}

	public void setInstrucaouso(String instrucaouso) {
		this.instrucaouso = instrucaouso;
	}

	public Integer getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(Integer idconsulta) {
		this.idconsulta = idconsulta;
	}
	
	

}
