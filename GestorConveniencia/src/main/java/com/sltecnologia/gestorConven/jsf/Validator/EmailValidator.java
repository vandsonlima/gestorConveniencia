package com.sltecnologia.gestorConven.jsf.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class EmailValidator implements Validator{
	 public void validate(FacesContext context, UIComponent component, Object value)
	            throws ValidatorException {
	
	String email = (String) value;
	Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
	Matcher m = p.matcher(email);
	
	boolean matchFound = m.matches();
	 
    if(!matchFound) {
        FacesMessage message = new FacesMessage();
        message.setDetail("E-mail Incorreto!");
        message.setSummary("E-mail Incorreto!");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(message);
    	}
	}
}