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
@Table(name = "pessoa", schema="gestor")
public class Pessoa implements Identificavel {

	// Atributos de Pessoa
	@Id
	@Column(name = "id_pessoa")
	@SequenceGenerator(name = "pessoa_id_pessoa_seq", sequenceName = "pessoa_id_pessoa_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pessoa_id_pessoa_seq")
	private int id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "telefone", length = 10, nullable = false)
	private String telefone;
	
	@Column(name = "senha", length = 64, nullable = false)
	private String senha;

	@Column(name = "sexo", length = 1, nullable = false)
	private String sexo;

	@Column(name = "cpf_cnpj", length = 14, nullable = false, unique = true)
	private String cpfCnpj;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@Column(name = "status", length = 1, nullable = false)
	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao", nullable = false)
	private Date dataAlteracao;

	@Column(name = "autorizado", nullable = false)
	private boolean autorizado;

	@Column(name="hash_auto_confirmacao", length = 64)
	private String hashAutoConfirmacao;

	@Column(name = "tipo_pessoa", length = 1, nullable = false)
	private int tipoPessoa;

	@Column(name = "verificado", length = 1)
	private boolean verificado;

	
	// Getters and Setters de Pessoa
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public String getHashAutoConfirmacao() {
		return hashAutoConfirmacao;
	}

	public void setHashAutoConfirmacao(String hashAutoConfirmacao) {
		this.hashAutoConfirmacao = hashAutoConfirmacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
	

}