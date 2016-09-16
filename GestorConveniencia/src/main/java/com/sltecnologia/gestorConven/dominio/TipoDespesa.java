package com.sltecnologia.gestorConven.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Tipo de despesa financeira
 * 
 * @author vandson
 *
 */
@Entity
@Table(name="tipo_despesa", schema="gestor")
public class TipoDespesa implements Identificavel{
	
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
	 * Define se o Objeto está ativo ou não
	 */
	private int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
