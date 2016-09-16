package com.sltecnologia.gestorConven.Services;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.sltecnologia.gestorConven.dominio.Pessoa;

public class UsuarioService {

	@Inject
	private EntityManager entityManager;

	/**
	 * M�todo utilizado para processar o login do usu�rio
	 * 
	 * @param pessoa
	 * @return
	 */
	public Pessoa efetuarLogin(Pessoa pessoa) {
		ArrayList<MensagemErro> listaErros = new ArrayList<MensagemErro>();
		if (pessoa.getEmail() != null || pessoa.getEmail().equals("")) {

			Pessoa p = findbyEmail(pessoa.getEmail());

			if (ValidatorUtils.isEmpty(p)) {
				listaErros.add(new MensagemErro("",
						"Usu�rio e/ou Senha inv�lidos!"));
			} else {
				String senha = StringUtils.toMD5(pessoa.getSenha());
				if (p.getSenha().equals(senha)) {
					return pessoa;
				} else {
					listaErros.add(new MensagemErro("",
							"Usu�rio e/ou Senha inv�lidos!"));
				}
			}
		}
		if(!listaErros.isEmpty())
			throw new NegocioException(listaErros);
		
		return new Pessoa();
	}

	public Pessoa findbyEmail(String email) {
		try {
			Query q = (Query) entityManager
					.createQuery("select p from Pessoa p where p.email = :email");
			q.setParameter("email", email);
			return (Pessoa) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
