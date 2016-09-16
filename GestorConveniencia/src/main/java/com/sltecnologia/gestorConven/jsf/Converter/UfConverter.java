package com.sltecnologia.gestorConven.jsf.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.sltecnologia.gestorConven.dominio.UnidadeFederativa;

@FacesConverter(forClass=UnidadeFederativa.class)
public class UfConverter implements Converter{

	
	private EntityManager EntityManager;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value != null && !value.equals("")) {
		return EntityManager.find(UnidadeFederativa.class, Integer.parseInt(value));
	}
	return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value instanceof UnidadeFederativa) {
		UnidadeFederativa uf = (UnidadeFederativa) value;
		return String.valueOf(uf.getId());
	}
	return "";
	}


}
