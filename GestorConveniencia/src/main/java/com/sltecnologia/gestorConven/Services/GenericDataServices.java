package com.sltecnologia.gestorConven.Services;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sltecnologia.gestorConven.dominio.Pessoa;

/**
 * Responsável por manter todos os métodos que servirão 
 * a todos os demais services com consultas e afins.
 * 
 * @author vandson
 *
 */
public class GenericDataServices {
	
	@Inject
	private EntityManager em;
	
	

}
