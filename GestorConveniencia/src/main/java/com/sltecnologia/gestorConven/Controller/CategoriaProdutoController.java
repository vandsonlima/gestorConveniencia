package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.CategoriaProduto;

/**
 * Controller da categoria de produtos
 * 
 * @author Vandson
 *
 */
@Named
@RequestScoped
public class CategoriaProdutoController extends AbstractCadastroController{
	
	public CategoriaProdutoController() {
		init();
	}
	
	public void init(){
		obj = new CategoriaProduto();
	}
	
	public String initListar(){
		init();
		return "categoria_produto/lista.jsf";
	}
	
	public String initCadastro(){
		init();
		return "categoria_produto/form.jsf";
	}
	
	public String menuUrl(){
		return "/secured/cadastros/menu_cadastro.jsf";
	}
	
	public String dirBase(){
		return "/secured/cadastros/categoria_produto/";
	}
}
