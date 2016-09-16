package com.sltecnologia.gestorConven.jsf.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter
public class CepConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		/*
		 * Ir� converter CEP formatado para um sem pontos e tra�o. Ex.:
		 * 59000-000 torna-se 59000000
		 */
		String cep = value;
		if (value != null && !value.equals(""))
			cep = value.replaceAll("\\-", "");

		return cep;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		String cep = value.toString();
		if (cep != null && cep.length() == 8)
			cep = cep.substring(0, 5) + "-" + cep.substring(5, 8);
		return cep;
	}

}
