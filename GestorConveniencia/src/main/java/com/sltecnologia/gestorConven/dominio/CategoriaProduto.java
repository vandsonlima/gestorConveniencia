package com.sltecnologia.gestorConven.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="categoria_produto", schema="gestor")
public class CategoriaProduto implements Identificavel {
	
	/**
	 * Identificador unico de uam categoria de produto
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denominação da categoria do produto
	 */
	@NotEmpty(message="Denominação: Campo Obrigatório não preenchido")
	@Size(min = 3, max = 40 , message="Denominação: deve ter entre {min} e {max} caracteres")
	private String denominacao;
	
	/**
	 * texto descritivo da categoria que irá aparecer para o cliente 
	 */
	private String descricao;
	
	
	/**
	 * Define se o Objeto está ativo ou não
	 */
	private int status;
	//Constructors
	
	/**
	 * Construtor Padrão
	 */
	public CategoriaProduto() {
		
	}
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public CategoriaProduto(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 */
	public CategoriaProduto(int id, String denominacao, String descricao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
		this.status = Status.ATIVO;
	}

	
	
	//getters and setters -------
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenominacao() {
		return denominacao;
	}
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}		

}
