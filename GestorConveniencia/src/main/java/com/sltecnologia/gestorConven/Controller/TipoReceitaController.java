package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.TipoReceita;

/**
 * Controller da Marca de produtos
 * @author vandson
 *
 */
@Named
@RequestScoped
public class TipoReceitaController extends AbstractCadastroController{

	public TipoReceitaController() {
		init();
	}
	public void init(){
		obj = new TipoReceita();
	}
	
	public String initListar(){
		init();
		return "tipo_receita/lista.jsf";
	}
	
	public String initCadastro(){
		init();
		return "tipo_receita/form.jsf";
	}
	
	public String menuUrl(){
		return "/secured/cadastros/menu_cadastro.jsf";
	}
	
	public String dirBase(){
		return "/secured/cadastros/tipo_receita/";
	}

}
