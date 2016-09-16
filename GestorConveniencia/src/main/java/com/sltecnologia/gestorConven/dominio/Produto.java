package com.sltecnologia.gestorConven.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Representa um produto disponï¿½vel na loja
 * @author Usuario
 *
 */
@Entity
public class Produto implements Identificavel{
	
	/**
	 * Identificador único do produto no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denominação do produto, descreve-o de forma sucinta.
	 */
	@NotEmpty(message="Denominação: Campo obrigatório não preenchido")
	@Size(min=3, max=140, message="Denominação: deve ter entre {min} e {max} caracteres")
	private String denominacao;
	
	/**
	 * Descricao do produto, detalhes sobre o produto
	 */
	@Size(max=300, message="Descrição deve ter no máximo {max} caracteres")
	private String descricao;
	
	/**
	 * Preço do produto
	 */
	@NotNull(message="Preço deve ser preenchido")
	private Double preco;
	
	/**
	 * Categoria da qual o produto pertence
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="Selecione uma categoria do produto")
	private CategoriaProduto categoriaProduto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="Selecione uma Marca do produto")
	private Marca marcaProduto;
	
	private int status;
	
	//constructors----------
	
	/**
	 * Construtor padrão
	 */
	public Produto() {
		categoriaProduto = new CategoriaProduto();
		marcaProduto = new Marca();
	}
	
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Produto(int id) {
		
		this.id = id;
		categoriaProduto = new CategoriaProduto();
		marcaProduto = new Marca();

	}
	
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 * @param descricao
	 * @param preco
	 */
	public Produto(int id, String denominacao, String descricao, Double preco) {
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
		this.preco = preco;
		categoriaProduto = new CategoriaProduto();
		marcaProduto = new Marca();
	}



	//getters and setters ----- 
	
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Marca getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(Marca marcaProduto) {
		this.marcaProduto = marcaProduto;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}	

}
