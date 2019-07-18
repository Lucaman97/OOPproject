package com.esame.progetto.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 * Rappresenta la classe i cui oggetti sono ritornati dal Controller.
*/
public class Statistiche {


	// metodi

	public Statistiche() {
		
	}


	public static Object pickMethod(Record r, String fieldName) {
		Object toReturn = null;
		//Prepara il nome del metodo (get + fieldName in cui si rende la prima maiuscola)
		String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		//	Ottieni un'istanza del metodo
		try {
			Method toInvoke = Record.class.getMethod(methodName);
			toReturn = toInvoke.invoke(r, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			System.out.println("Metodo non esistente");
		} catch (SecurityException e) {
			e.printStackTrace();
			System.out.println("Security exception");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
}