package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.Marca;

/**
 * Controller do tipo de receita
 * @author vandson
 *
 */
@Named
@RequestScoped
public class TipoOfertaController extends AbstractCadastroController{

	public TipoOfertaController() {
		init();
	}
	public void init(){
		obj = new Marca();
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
