package com.vhsadev.springpodcasts.models.dto;

public class ResponseDTO<T> {

	private String mensagem;
	
	private Object dado;
	
	

	public ResponseDTO(String mensagem, Object dado) {
		this.mensagem = mensagem;
		this.dado = dado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getDado() {
		return dado;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}
	
	
}
