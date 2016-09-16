package com.sltecnologia.gestorConven.Services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String toMD5(String senha){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance( "MD5" );
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		md.update( senha.getBytes() );  
		BigInteger hash = new BigInteger( 1, md.digest() );  
		return hash.toString(16);
	}
	
	public static String formatarMoeda(BigDecimal moeda){
		NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
		double valor = moeda.doubleValue();
		
		return nf.format(valor);
	}
	
	public static String completarZero(int numero, int quantidade){
		return String.format("%0"+quantidade+"d", numero);
	}
	
	public static String formatCPF(String cpf) {
		Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
		Matcher matcher = pattern.matcher(cpf);
		if (matcher.matches()) 
			cpf = matcher.replaceAll("$1.$2.$3-$4");
		return cpf;		
	}
	
	public static String converteToAscii(String str) { 
		str = Normalizer.normalize(str, Normalizer.Form.NFD); 
		str = str.replaceAll("[^\\p{ASCII}]", ""); 
		return str; 
	}
	
	public static String formataNomeCompleto(String nome){
		String sNova = ""; 
		for (String sNome : nome.toLowerCase().split(" ")) { 
		    if (!"".equals(sNome)) { 
		        if (!"".equals(sNova)) sNova += " "; 
		        if (sNome.length()>2) { // utilizado para nomes próprios, para não colocar maiúscula em De, por exemplo 
		            sNova += sNome.substring(0,1).toUpperCase() + sNome.substring(1); 
		        } else { 
		            sNova += sNome; 
		        } 
		    } 
		}
		return sNova;
	}
}
