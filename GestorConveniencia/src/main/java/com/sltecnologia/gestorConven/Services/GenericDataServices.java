package com.sltecnologia.gestorConven.Services;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sltecnologia.gestorConven.dominio.Pessoa;

/**
 * Respons�vel por manter todos os m�todos que servir�o 
 * a todos os demais services com consultas e afins.
 * 
 * @author vandson
 *
 */
public class GenericDataServices {
	
	@Inject
	private EntityManager em;
	
	

}
