package com.sltecnologia.gestorConven.Controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sltecnologia.gestorConven.dominio.Marca;
import com.sltecnologia.gestorConven.dominio.TipoDespesa;

/**
 * Controller do tipo de despesa
 * @author vandson
 *
 */
@Named
@RequestScoped
public class TipoDespesaController extends AbstractCadastroController{

	public TipoDespesaController() {
		init();
	}
	public void init(){
		obj = new TipoDespesa();
	}
	
	public String initListar(){
		init();
		return "tipo_despesa/lista.jsf";
	}
	
	public String initCadastro(){
		init();
		return "tipo_despesa/form.jsf";
	}
	
	public String menuUrl(){
		return "/secured/cadastros/menu_cadastro.jsf";
	}
	
	public String dirBase(){
		return "/secured/cadastros/tipo_despesa/";
	}

}
