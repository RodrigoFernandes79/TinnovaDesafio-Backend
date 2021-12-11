package com.tinnova.ex05controleDeVeiculos.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;







@Entity
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Campo Obrigatório!")
	private String veiculo;
	@NotBlank(message="Campo Obrigatório!")
	private String marca;
	@NotNull(message="Campo Obrigatório!")
	private Integer ano;
	private String descricao;
	private boolean vendido;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate created;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate updated;

	public Veiculo() {

	}

	public Veiculo(Long id, String veiculo, String marca, Integer ano, String descricao, boolean vendido,
			LocalDate created, LocalDate updated) {
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
	
	@PrePersist
	public void criarDataCadastro() {
		 setCreated(LocalDate.now());
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
	
	public LocalDate getCreated() {
		return created;
	}
	
	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
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
	