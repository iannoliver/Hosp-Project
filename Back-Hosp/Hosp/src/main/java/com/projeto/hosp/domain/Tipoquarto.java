package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Tipoquarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipo;
	
	@Column(nullable = false)
	private Double valordiario;
	
	@Column(nullable = false)
	private String descquarto;

	public Tipoquarto() {
	}

	public Tipoquarto(Integer idtipo, Double valordiario, String descquarto) {
		this.idtipo = idtipo;
		this.valordiario = valordiario;
		this.descquarto = descquarto;
	}

	public Integer getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	public Double getValordiario() {
		return valordiario;
	}

	public void setValordiario(Double valordiario) {
		this.valordiario = valordiario;
	}

	public String getDescquarto() {
		return descquarto;
	}

	public void setDescquarto(String descquarto) {
		this.descquarto = descquarto;
	}
	
	
}
