package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.Marca;

/**
 * Controller da Marca de produtos
 * @author vandson
 *
 */
@Named
@RequestScoped
public class MarcaController extends AbstractCadastroController{

	public MarcaController() {
		init();
	}
	public void init(){
		obj = new Marca();
	}
	
	public String initListar(){
		init();
		return "marca/lista.jsf";
	}
	
	public String initCadastro(){
		init();
		return "marca/form.jsf";
	}
	
	public String menuUrl(){
		return "/secured/cadastros/menu_cadastro.jsf";
	}
	
	public String dirBase(){
		return "/secured/cadastros/marca/";
	}

}
