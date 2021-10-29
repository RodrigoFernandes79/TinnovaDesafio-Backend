package com.tinnova.ex05controleDeVeiculos.Dto;

import java.io.Serializable;



public class VeiculosNaoVendidosDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String situacao;
	private Integer quantidade;

	public VeiculosNaoVendidosDto() {

	}

	public VeiculosNaoVendidosDto(String situacao, Integer quantidade) {
		super();
		this.situacao = situacao;
		this.quantidade = quantidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
