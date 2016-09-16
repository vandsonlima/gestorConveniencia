package com.sltecnologia.gestorConven.Services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Classe responsável por produzir e destruir o 
 * EntityManager a cada requisição
 * @author vandson
 *
 */
public class EntityManagerProdutor {
	
	@Produces @ApplicationScoped
	public EntityManagerFactory criaFactory(){
		return Persistence.createEntityManagerFactory("ConexaoDB");
	}
	
	@Produces
	@RequestScoped
	public EntityManager criaEM(EntityManagerFactory factory){
		return factory.createEntityManager();
	}
	
	public void finaliza(@Disposes EntityManager entityManager){
		entityManager.close();
	}
}
