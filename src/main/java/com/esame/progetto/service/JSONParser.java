package com.esame.progetto.service;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe parser di un oggetto JSON.
 * Ogni istanza accetta un oggetto JSON del tipo:
 * 
 * {
 * 	"colonna" : {"tipoFiltro" : valoreFiltro}
 * }
 * 
 * e ne parsifica il contenuto, fornendo gli adeguati getters.
 * valoreFiltro può essere ritornato come intero o come Array di stringhe.
 */
public class JSONParser {
	
	/**
	 * L'oggetto json da parsificare, convertito in formato JSONObject
	 */
	private JSONObject json;
	/**
	 * Nome della colonna da filtrare.
	 */
	private String value;
	/**
	 * Nome del tipo di filtro
	 */
	private String filterType;
	/**
	 * Valore del filtro. Inizialmente salvato come Object, poi castato al tipo richiesto dal getter.
	 */
	private Object filterValue;
	
	/**
	 * Costruisce un parser che conserva i valori definiti nell'oggeto JSON passsato come parametro.
	 * @param json L'oggetto JSON da parsificare.
	 */
	public JSONParser(String jsonString) {
		this.json = new JSONObject(jsonString);
		
		//Estrae il valore prendendo il primo (e, in questo caso, unico) valore delle chiavi
		this.value = (JSONObject.getNames(json))[0];
		
		
		
		//Oggetto intermedio che incapsula tipo e valore del filtro
		JSONObject filterDetails = json.getJSONObject(value);
		
		//Estrazione dell'unica coppia chiave-valore che rappresenta il filtro
		this.filterType = (JSONObject.getNames(filterDetails))[0];
		this.filterValue = filterDetails.get(filterType);
	}
	
	/**
	 * Ritorna il nome del campo da filtrare sotto forma di stringa
	 * @return Il nome del campo da filtrare
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Ritorna il nome che identifica un tipo di filtro.
	 * @return Il tipo di filtro da applicare
	 */
	public String getFilterType() {
		return filterType;
	}
	
	/**
	 * Ritorna il valore che viene applicato al filtro, interpretato come intero.
	 * @return il valore del filtro in formato int
	 */
	public double getNumFilterVal() {
		return (double) filterValue;
	}
	
	/**
	 * Ritorna il valore che viene applicato al filtro, interpretato come array di stringhe.
	 * @return il valore del filtro in formato String[]
	 */
	public String[] getArrayFilterVal() {
		JSONArray filterValues =  (JSONArray) filterValue;
//		Istanzia un nuovo vettore di stringhe da ritornare
		String filterValuesString[] = new String[filterValues.length()];
//		Trasferisci ogni valore del JSONArray nell'array di stringhe
		for (int i = 0; i < filterValues.length(); i++) {
			filterValuesString[i] = filterValues.getString(i);
		}
		return filterValuesString;
	}
	
}