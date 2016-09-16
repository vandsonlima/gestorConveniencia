package com.sltecnologia.gestorConven.jsf.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter
public class TelefoneConverter implements Converter {
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Ir� converter CPF formatado para um sem pontos e tra�o.
         * Ex.: 355.245.198-87 torna-se 35524519887.
         */
         String telefone = value;
         if (value!= null && !value.equals(""))
              telefone = value.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");

         return telefone;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
      
    	 String telefone = value.toString();
    	 if(telefone != null && telefone.length() == 10)
    		 telefone = "(" + telefone.substring(0,2) + ")" + telefone.substring(2,6) + "-" + telefone.substring(6,10);
    	return telefone;
    }
    	
    	
}
