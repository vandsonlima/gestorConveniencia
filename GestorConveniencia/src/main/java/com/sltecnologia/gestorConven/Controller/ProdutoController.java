package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.Produto;

/**
 * Classe responsavel por controlar Produtos
 * 
 * @author vandson
 *
 */
@Named
@RequestScoped
public class ProdutoController extends AbstractCadastroController{

	public ProdutoController() {
		init();
	}
	
	@Override
	void init() {
		obj = new Produto();		
	}

	@Override
	public String initListar() {
		init();
		return "estoque/produto/lista.jsf";
	}

	@Override
	public String initCadastro() {
		init();
		return "produto/form.jsf";
	}

	@Override
	public String dirBase() {
		return "/secured/estoque/produto";
	}

	@Override
	public String menuUrl() {
		return "/secured/estoque/menu_estoque.jsf";
	}
	
	

}
