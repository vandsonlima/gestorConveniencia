package com.sltecnologia.gestorConven.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sltecnologia.gestorConven.Services.MensagemErro;
import com.sltecnologia.gestorConven.dominio.Pessoa;

public class AbstractController {

	private HttpSession session;

	public void addMensagemErro(String mensagem) {
		addMensagemErro("", mensagem);
	}

	public void addMensagemErro(String campo, String mensagem) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		msg.setSummary(mensagem);
		FacesContext.getCurrentInstance().addMessage(campo, msg);
	}

	public void addMensagemErro(ArrayList<MensagemErro> listaMensagem) {
		if (listaMensagem != null && !listaMensagem.isEmpty()) {
			for (MensagemErro erro : listaMensagem) {
				addMensagemErro(erro.getCampo(), erro.getMensagem());
			}

		}
	}

	public void addMensagemInfo(String mensagem) {
		addMensagemInfo("", mensagem);
	}

	public void addMensagemInfo(String campo, String mensagem) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary(mensagem);
		FacesContext.getCurrentInstance().addMessage(campo, msg);
	}

	public void redirect(String pagina) {
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.getExternalContext().redirect(pagina);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Mensagem FATAL
	public void addMensagemFatal(String mensagem, String detalhe) {
		addMensagemFatal("", mensagem, detalhe);
	}

	public void addMensagemFatal(String campo, String mensagem, String detalhe) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_FATAL);
		msg.setSummary(mensagem);
		msg.setDetail(detalhe);
		FacesContext.getCurrentInstance().addMessage(campo, msg);
	}

	/**
	 * método que retorna o usuario logado.
	 * 
	 * @return
	 */
	public Pessoa getUsuarioLogado() {
		Pessoa pessoa = new Pessoa();
		FacesContext ctx = FacesContext.getCurrentInstance();
		setSession((HttpSession) ctx.getExternalContext().getSession(false));
		pessoa = (Pessoa) getSession().getAttribute("usuario");
		return pessoa;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
