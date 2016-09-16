package com.sltecnologia.gestorConven.jsf.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sltecnologia.gestorConven.dominio.Municipio;

@FacesConverter(forClass=Municipio.class)
public class MunicipioConverter implements Converter {

	@Inject
	private EntityManager entityManager;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.equals("")) {
			return entityManager.find(Municipio.class, Integer.parseInt(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Municipio) {
			Municipio municipio = (Municipio) value;
			return String.valueOf(municipio.getId());
		}
		return "";
	}
}
