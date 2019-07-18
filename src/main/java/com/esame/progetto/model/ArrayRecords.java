package com.esame.progetto.model;

import java.util.ArrayList;

import com.esame.progetto.service.DataFromLink;
import com.esame.progetto.utilities.Filter;
import com.esame.progetto.utilities.FilterUtils;



/**
 * Oggetto che rappresenta tutta la struttura del dataset.
 * Implementa Filter che viene utilizzato per i filtri.
 */
public class ArrayRecords implements Filter<Record, Object>{

	private static ArrayList<Metadata> metadata = DataFromLink.getArrayMetadata();
	private static ArrayList<Record>  records = DataFromLink.getRecords();
	private FilterUtils<Record> utils;

	
	/**
	 *	Funzione costruttore che effettua il filtro sui records.
	 */
	public ArrayList<Record> filterField(String fieldName, String operator, Object ... value) {
		// TODO Auto-generated method stub
	
		return (ArrayList<Record>) utils.select(records, fieldName, operator, value);
	}

	public ArrayRecords(ArrayList<Record> recordsParam) {
		super();
		records = recordsParam;
		this.utils = new FilterUtils<Record>();
	}

	public ArrayRecords(ArrayList<Record> recordsParam, FilterUtils<Record> utils) {
		super();
		records = recordsParam;
		this.utils = utils;
	}
	


	public ArrayRecords() {
		super();
		records=DataFromLink.getRecords();
		// TODO Auto-generated constructor stub
	}
	/**Inizializza e restituisce l'array list di Data
	 * @return L'intero ArrayList di oggetti Record
	*/

	public static ArrayList<Record> getRecords() {
		return records;
	}	
	/**
	 * Inizializza e restituisce l'array list di Metadata
	 * @return ArrayList di oggetti Metadata
	 */
	
	public static ArrayList<Metadata> getArrayMetadata() {
		return metadata;
	}

	}
	