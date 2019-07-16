package com.esame.progetto.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import com.esame.progetto.service.Terminal;
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;

public class Statistiche {

//statistica per i campi stringa
//PROBABLY NEED TO SET IT AS AN HASHMAP, STAY TUNED

	/*
	 * //Provato con HashMap e LambdaExpression invece dei Switch ma dopo 5 giorni
	 * di prove inutili ///direi che è più semplice così
	 * 
	 * Map<String, Retriever> hashCommand = new HashMap<>(); interface Retriever {
	 * float retrieve(); }
	 */

	// metodi

	public Statistiche() {
		
	}

	/*
	public Statistiche(ArrayList<Record> record, String fieldName) {
		if (fieldName == "FREQ" || fieldName == "GEO" || fieldName == "OBJ") {
		}
	}*/

	public static Object pickMethod(Record r, String fieldName) {
		Object toReturn = null;
//	Prepara il nome del metodo (get + fieldName in cui si rende la prima maiuscola)
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