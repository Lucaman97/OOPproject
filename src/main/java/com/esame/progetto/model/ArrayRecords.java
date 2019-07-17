package com.esame.progetto.model;

import java.util.ArrayList;

import com.esame.progetto.service.CsvData;
import com.esame.progetto.utilities.Filter;
import com.esame.progetto.utilities.FilterUtils;



public class ArrayRecords implements Filter<Record, Object>{

	private static ArrayList<Record>  records = CsvData.getRecords();
	private static ArrayList<Metadata> metadata = CsvData.getArrayMetadata();
	private FilterUtils<Record> utils;

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
		records=CsvData.getRecords();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return L'intero ArrayList di oggetti Record
	*/

	public static ArrayList<Record> getRecords() {
		return records;
	}	
	/**
	 * Inizializza e restituisce l array list di Metadata
	 * @return ArrayList di oggetti Metadata
	 */
	
	public static ArrayList<Metadata> getArrayMetadata() {
		return metadata;
	}

	}
	