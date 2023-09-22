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
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idconsulta;
	
	@Column(nullable = false)
	private Date dataconsulta;
	
	@Column(nullable = false)
	private Time horaconsulta;
	
	@Column(nullable = false)
	private Double valorconsulta;
	
	@JoinColumn(name = "idmedico")
	private Integer idmedico;
	
	@JoinColumn(name = "idpaciente")
	private Integer idpaciente;
	
	@JoinColumn(name = "idespecialidade")
	private Integer idespecialidade;

	public Consulta() {
	}

	public Consulta(Integer idconsulta, Date dataconsulta, Time horaconsulta, Double valorconsulta, Integer idmedico,
			Integer idpaciente, Integer idespecialidade) {
		this.idconsulta = idconsulta;
		this.dataconsulta = dataconsulta;
		this.horaconsulta = horaconsulta;
		this.valorconsulta = valorconsulta;
		this.idmedico = idmedico;
		this.idpaciente = idpaciente;
		this.idespecialidade = idespecialidade;
	}

	public Integer getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(Integer idconsulta) {
		this.idconsulta = idconsulta;
	}

	public Date getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(Date dataconsulta) {
		this.dataconsulta = dataconsulta;
	}

	public Time getHoraconsulta() {
		return horaconsulta;
	}

	public void setHoraconsulta(Time horaconsulta) {
		this.horaconsulta = horaconsulta;
	}

	public Double getValorconsulta() {
		return valorconsulta;
	}

	public void setValorconsulta(Double valorconsulta) {
		this.valorconsulta = valorconsulta;
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

	public Integer getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Integer idespecialidade) {
		this.idespecialidade = idespecialidade;
	}
	
	

}
