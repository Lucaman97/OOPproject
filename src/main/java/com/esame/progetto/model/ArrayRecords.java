package com.esame.progetto.model;

import java.util.ArrayList;
import java.util.Collection;

import com.esame.progetto.utilities.*;

public class ArrayRecords implements Filter<Record, Object>{

	private static ArrayList<Record>  records = new ArrayList<Record>();
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();

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
	@Override
	public Collection<Record> filterField(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
