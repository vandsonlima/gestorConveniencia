package com.sltecnologia.gestorConven.Services;

import java.util.Collection;
import java.util.Map;

import com.sltecnologia.gestorConven.dominio.Identificavel;

public class ValidatorUtils {

	/**
	 * Valida se string � diferente de null e n�o � vazia.
	 *
	 * @return
	 */
	public static final boolean isEmpty(String s) {
		return (s == null || s.trim().length() == 0);
	}

	/**
	 * Valida se um objeto � vazio. O seu funcionamento vai depender do tipo de
	 * objeto passado como par�metro. Se o objeto for nulo, � vazio. Se for uma
	 * tring, verifica se n�o � string vazia ou n�o � formada apenas por
	 * espa�os. Se for uma cole��o, verifica se a cole��o est� vazia, etc.
	 *
	 * @return
	 */
	public static final boolean isEmpty(Object o) {
		if (o == null)
			return true;
		if (o instanceof String)
			return isEmpty((String) o);
		if (o instanceof Number) {
			Number i = (Number) o;
			return (i.intValue() == 0);
		}
		if (o instanceof Identificavel)
			return ((Identificavel) o).getId() == 0;
		if (o instanceof Object[])
			return ((Object[]) o).length == 0;
		if (o instanceof int[])
			return ((int[]) o).length == 0;
		if (o instanceof Collection<?>)
			return ((Collection<?>) o).size() == 0;
		if (o instanceof Map<?, ?>)
			return ((Map<?, ?>) o).size() == 0;

		return false;
	}

	/**
	 * Verifica se um objeto n�o est� vazio. � a nega��o do m�todo isEmpty.
	 * 
	 * @param o
	 * @return
	 */
	public static final boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

}
