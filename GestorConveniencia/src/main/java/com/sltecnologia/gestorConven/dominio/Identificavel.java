package com.sltecnologia.gestorConven.dominio;


/**
 * Interface que representa uma entidade que ser persistida em banco de dados.
 * @author Vandson
 *
 */
public interface Identificavel {

	public int getId();
	
	public void setId(int id);
	
	public int getStatus();
	
	public void setStatus(int status);
}
