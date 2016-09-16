package com.sltecnologia.gestorConven.Services;


public class MensagemErro {

	private String campo;

	private String mensagem;

	public MensagemErro() {
	}

	public MensagemErro(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return (campo != null ? campo + ":" : "") + mensagem;
	}

}
