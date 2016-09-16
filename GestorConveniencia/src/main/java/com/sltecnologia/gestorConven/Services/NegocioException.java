package com.sltecnologia.gestorConven.Services;

import java.util.ArrayList;

public class NegocioException extends RuntimeException{
	

	private ArrayList<MensagemErro> listaMensagem = new ArrayList<MensagemErro>();
	
	private static final long serialVersionUID = -8762819682590130195L;

	public NegocioException() {
		super("Ocorreu um erro no sistema. Tente novamente.");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
	public NegocioException(ArrayList<MensagemErro> listaMensagem) {
		super(" ");
		this.listaMensagem = listaMensagem;
	}
	
	public void addErro(String campo,String mensagem){
		listaMensagem.add(new MensagemErro(campo, mensagem));
	}
	
	public void setListaMensagem(ArrayList<MensagemErro> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}
	
	public ArrayList<MensagemErro> getListaMensagem() {
		return listaMensagem;
	}
	
	public boolean possuiMensagem(){
		return listaMensagem.isEmpty();
	}

}
