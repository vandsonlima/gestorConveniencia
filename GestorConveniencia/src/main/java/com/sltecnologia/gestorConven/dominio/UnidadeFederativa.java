package com.sltecnologia.gestorConven.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="unidade_federativa", schema="gestor")
public class UnidadeFederativa implements Identificavel {
	
	// Atributos de Unidade Federativa
	@Id
	@Column(name = "id_uf")
	@SequenceGenerator(name = "uf_id_uf_seq", sequenceName = "uf_id_uf_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uf_id_uf_seq" )
	private int id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "sigla", length = 2, nullable = false)
	private String sigla;
	
	@Column(name = "status", length = 1, nullable = false)
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao", nullable = false)
	private Date dataAlteracao;

	
	// Getters and Setters de Unidade Federativa
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
	
		final UnidadeFederativa other = (UnidadeFederativa) obj;
			if (this.id != other.id && (this.id == 0 || this.id != other.id)) {
				return false;
			}
	
			return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 41 * hash + (this.id > 0 ? this.id : 0);
		return hash;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}
