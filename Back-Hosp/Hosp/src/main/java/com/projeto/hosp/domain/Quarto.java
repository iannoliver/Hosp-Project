package com.projeto.hosp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idquarto;
	
	@Column(nullable = false, unique=true)
	private Integer numero;
	
	@JoinColumn(name = "idtipo")
	private Integer idtipo;

	public Quarto() {
	}

	public Quarto(Integer idquarto, Integer numero, Integer idtipo) {
		this.idquarto = idquarto;
		this.numero = numero;
		this.idtipo = idtipo;
	}

	public Integer getIdquarto() {
		return idquarto;
	}

	public void setIdquarto(Integer idquarto) {
		this.idquarto = idquarto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}
	
	
}
