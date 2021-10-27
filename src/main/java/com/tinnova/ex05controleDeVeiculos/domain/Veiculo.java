package com.tinnova.ex05controleDeVeiculos.domain;

import java.io.Serializable;
import java.time.Instant;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;







@Entity
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	@Column(columnDefinition ="TEXT")
	private String descricao;
	private boolean vendido;
	@JsonFormat(timezone = "America/Recife")
	private Instant created;
	@JsonFormat(timezone = "America/Recife")
	private Instant updated;
	
	
	
	public Veiculo() {
		
	}



	public Veiculo(Long id, String veiculo, String marca, Integer ano, String descricao, boolean vendido,
			Instant created, Instant updated) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
		this.updated = updated;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getVeiculo() {
		return veiculo;
	}



	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public Integer getAno() {
		return ano;
	}



	public void setAno(Integer ano) {
		this.ano = ano;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isVendido() {
		return vendido;
	}



	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}


	public Instant getCreated() {
		return created;
	}



	public void setCreated(Instant created) {
		this.created = created;
	}



	public Instant getUpdated() {
		return updated;
	}



	public void setUpdated(Instant updated) {
		this.updated = updated;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	



	


	

}

	