package com.sltecnologia.gestorConven.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.sltecnologia.gestorConven.Services.UsuarioService;
import com.sltecnologia.gestorConven.dominio.Pessoa;

@Named
@RequestScoped
public class UsuarioController extends AbstractController {

	@Inject
	private Pessoa pessoa;

	@Inject
	private UsuarioService service;

	private String email;
	private String hash;
	private HttpSession session;
	private String novaSenha;
	private String senhaAtual;
	private String repetNovaSenha;
	private String bemvindo;

	@PostConstruct
	public void init() {

	}

	public String efetuarLogin() {
/*		try {
			pessoa = service.efetuarLogin(pessoa);
			if (pessoa.getId() > 0) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				session = (HttpSession) ctx.getExternalContext().getSession(
						false);
				session.setAttribute("usuario", pessoa);

				return "index";
			}
		} catch (NegocioException e) {
			addMensagemErro(e.getListaMensagem());
		}*/
		FacesContext ctx = FacesContext.getCurrentInstance();
		session = (HttpSession) ctx.getExternalContext().getSession(
				false);
		pessoa.setId(1);
		pessoa.setNome("Valdir Eloi");
		pessoa.setEmail("teste@teste.com.br");
		
		session.setAttribute("usuario", pessoa);
		return "/secured/index";

	}
	
	/**
	 * método que efetua o logoff e limpa a sessão.
	 * @return
	 */
	public String encerrarSessao(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuario", null);
		session.invalidate();
		addMensagemInfo("Sessão encerrada!");
		return "/login.jsf";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getRepetNovaSenha() {
		return repetNovaSenha;
	}

	public void setRepetNovaSenha(String repetNovaSenha) {
		this.repetNovaSenha = repetNovaSenha;
	}

	public String getBemvindo() {
		return bemvindo;
	}

	public void setBemvindo(String bemvindo) {
		this.bemvindo = bemvindo;
	}
}
