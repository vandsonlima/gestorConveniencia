package com.sltecnologia.gestorConven.jsf.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter
public class RealConverter implements Converter {
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Ir� converter CPF formatado para um sem pontos e tra�o.
         * Ex.: 355.245.198-87 torna-se 35524519887.
         */
         String valorConsulta = value;
         if (value!= null && !value.equals(""))
        	 valorConsulta = value.replaceAll("[^0-9]", "");

         return valorConsulta;
    }

    @SuppressWarnings("unused")
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
    	 String valorConsulta = value.toString();
    	 int centavos = 0;
    	 int centena = 0;
    	 int milhares = 0;
		if(valorConsulta != null){
    		 centavos = valorConsulta.length() - 2;
    		 centena = centavos - 3;
    		 milhares  = valorConsulta.length() - centavos;
    		 valorConsulta = "R$ " + valorConsulta.substring(0,centena) + "." + valorConsulta.substring(centena, centavos) + "," + valorConsulta.substring(centavos, valorConsulta.length());
		}
    	return valorConsulta;
    }
    	
    	
}