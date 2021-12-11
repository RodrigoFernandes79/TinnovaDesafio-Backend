package com.tinnova.ex05controleDeVeiculos.resource.exception;



public class ApiException   {

	private String campo;
	private String mensagem;
	
	
	
	public ApiException( String campo, String mensagem) {
		this.campo=campo;
		this.mensagem = mensagem;
		
	}
	public String getMensagem() {
		return mensagem;
	}
	public String getCampo() {
		return campo;
	}

	

}
