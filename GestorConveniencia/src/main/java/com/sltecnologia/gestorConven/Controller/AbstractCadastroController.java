package com.sltecnologia.gestorConven.Controller;

import java.util.Collection;

import javax.inject.Inject;

import com.sltecnologia.gestorConven.Services.GenericCadastroService;
import com.sltecnologia.gestorConven.dominio.Identificavel;

/**
 * Managed bean Abstrato que serve de base para todos os 
 * Managed beans que gerenciam operações de CRUD
 * 
 * @author Vandson
 *
 */
public abstract class AbstractCadastroController extends AbstractController {
	
	@Inject
	private GenericCadastroService genericCadastroService;
	
	protected Identificavel obj;
	
	abstract void init();
	
	abstract String initListar();
	
	abstract String initCadastro();
	
	/**
	 * Método que armazena o contexto do módulo
	 * @return
	 */
	abstract String dirBase();
	
	/**
	 * Método responsável por realizar o redirecionamento ao menu
	 * @return
	 */
	abstract String menuUrl();
	
	public String deletar(Identificavel obj){
		genericCadastroService.deletar(obj);
		addMensagemInfo("Registro em "+obj.getClass().getSimpleName()+" apagado(a) com sucesso.");
		return null;
	}
	
	public String inativar(Identificavel obj){
		genericCadastroService.inativar(obj);
		addMensagemInfo("Registro em "+obj.getClass().getSimpleName()+" inativado(a) com sucesso.");
		return null;
	}
	
	public String salvar() throws InstantiationException, IllegalAccessException {
		genericCadastroService.saveOrUpdate((Identificavel) obj);
		obj = obj.getClass().newInstance();
		addMensagemInfo("Registro em "+ obj.getClass().getSimpleName() +" salvo(a) com sucesso.");
		return menuUrl();
	}
	
	public String selecionar(Identificavel obj){
		this.obj = obj;
		return dirBase() + "form.jsf";
	}

	@SuppressWarnings("unchecked")
	public Collection<Identificavel> getListaCompleta(){
		return (Collection<Identificavel>) genericCadastroService.getListaCompleta(obj.getClass());
	}
	
	public void atualizar( Identificavel obj){
		genericCadastroService.update((Identificavel) obj);
	}

	public Identificavel getObj() {
		return (Identificavel) obj;
	}
	
	public void setObj(Identificavel obj) {
		this.obj = obj;
	}	
	


}
