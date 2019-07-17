package com.esame.progetto.utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilterUtils<T> {
	/*
	 * 
	 * Il filtro è puramente logico, realizzato con operatori logici tipici di MongoDB. HO risolto il problema con la creazione di una interfaccia Filter<E,T>, il cui unico metodo restituirà una generica Collection. Poi tramite un metodo Select, creato in un'altra classe creerò una Collection, tramite queste istruzioni:
	 * try {
		Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
		try {
		Object tmp = m.invoke(item);
	if(FilterUtils.check(tmp, operator, value))
	out.add(item);
	out sarà opportunatamente restituito nel Controller, in un metodo mappato di tipo GET.

	 */
	public static boolean check(Object value, String operator, Object ...th) {
		if (th[0] instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th[0]).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			
			if (operator.equals("$gt") || operator.contentEquals(">"))
				return valuec > thC;
			
				else if (operator.equals("$lt") || operator.contentEquals("<"))
				
				return valuec < thC;
				else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'operatore non è accettato e non può esser utilizzato come filtro.");
			
		}
		
		else if(th[0] instanceof String && value instanceof String)

			if(operator.equals("$in") || operator.equals("in"))
			{
				for(Object s: th)
				{
					if(value.equals((String)s)) return true;
				}
			return false;
			}
			
			else if(operator.equals("$nin") || operator.equals("nin"))
			{
				for(Object s: th)
				{
					if(value.equals((String)s)) return false;
				}
			return true;
			
		
			
	}
	else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'operatore non è accettato e non può esser utilizzato come filtro.");
		
	return false;	
	}
	
		Collection<T> out = new ArrayList<T>();
		public Collection<T> select(Collection<T> src, String fieldName, String operator, Object ...value){
		for(T item:src) {
			try {
				//getMethod ottiene il metodo che ha il nome come argomento, get class ottiene la classe di item
				Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1), null);
				
				try {
					Object tmp = m.invoke(item);
					if(FilterUtils.check(tmp, operator, value))
						out.add(item);					
						
					
					
					
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		
		return out;
	}
}
