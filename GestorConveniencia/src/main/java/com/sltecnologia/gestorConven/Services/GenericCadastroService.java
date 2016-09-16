package com.sltecnologia.gestorConven.Services;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sltecnologia.gestorConven.dominio.Identificavel;
import com.sltecnologia.gestorConven.dominio.Status;

/**
 * Classe que terá todos os métodos básicos para um crud
 * 
 * @author Vandson
 *
 */
public class GenericCadastroService {
	
	@Inject
	private EntityManager entityManager;

	public void deletar(Identificavel obj){
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
	}
	
	public void salvar(Identificavel obj){
		obj.setStatus(Status.ATIVO);
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	
	public void update(Identificavel objeto) {
		entityManager.getTransaction().begin();
		entityManager.merge(objeto);
		entityManager.getTransaction().commit();
	}
	
	public void saveOrUpdate(Identificavel objeto){
		objeto.setStatus(Status.ATIVO);
		if(objeto.getId() == 0)
			salvar(objeto);
		else		
			update(objeto);
    }
	
	public void inativar(Identificavel objeto){
		objeto.setStatus(Status.INATIVO);
		update(objeto);
	}

	@SuppressWarnings("unchecked")
	public <T> Collection<T> getListaCompleta(Class<T> classe){
		return (Collection<T>) entityManager.createQuery("from "+ classe.getSimpleName()  + " where status = 1 order by id").getResultList();		
	}
	
}
