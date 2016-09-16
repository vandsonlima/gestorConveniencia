package com.sltecnologia.gestorConven.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "municipio", schema="gestor")
public class Municipio implements Identificavel {

	// Atributos de Municipio
	@Id
	@Column(name = "id_municipio")
	@SequenceGenerator(name = "municipio_id_municipio_seq", sequenceName = "municipio_id_municipio_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "municipio_id_municipio_seq")
	private int id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "status", length = 1, nullable = false)
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao", nullable = false)
	private Date dataAlteracao;
	
	// Relacionamento nx1 com Unidade Federativa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidade_federativa", nullable = false)
	private UnidadeFederativa unidadeFederativa;
	
	
	// Getters and Setters de Munic�pio
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

	// Get para retonar a sigla da UF
	public String getNomeCompleto(){
		return nome + "/" + unidadeFederativa.getSigla();
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
		
		final Municipio other = (Municipio) obj;
			if (this.id != other.id && (this.id != other.id)) {
				return false;
			}
	
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + (this.id > 0 ? this.id : 0);
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

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}
	
}
