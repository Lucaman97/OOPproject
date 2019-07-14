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
		
		metadata.add(new Metadata("FREQ","Frequenza","String"));
		metadata.add(new Metadata("GEO","Geolocalità","String"));
		metadata.add(new Metadata("UNIT","Unita","String"));
		metadata.add(new Metadata("ObjectiveTimePeriod","Periodo","String"));
		metadata.add(new Metadata("anno2000", "Anno", "Float"));
		metadata.add(new Metadata("anno2001", "Anno", "Float"));
		metadata.add(new Metadata("anno2002", "Anno", "Float"));
		metadata.add(new Metadata("anno2003", "Anno", "Float"));
		metadata.add(new Metadata("anno2004", "Anno", "Float"));
		metadata.add(new Metadata("anno2005", "Anno", "Float"));
		metadata.add(new Metadata("anno2006", "Anno", "Float"));
		metadata.add(new Metadata("anno2007", "Anno", "Float"));
		metadata.add(new Metadata("anno2008", "Anno", "Float"));
		metadata.add(new Metadata("anno2009", "Anno", "Float"));
		metadata.add(new Metadata("anno2010", "Anno", "Float"));
		metadata.add(new Metadata("anno2011", "Anno", "Float"));
		metadata.add(new Metadata("anno2012", "Anno", "Float"));
		metadata.add(new Metadata("anno2013", "Anno", "Float"));
		metadata.add(new Metadata("anno2014", "Anno", "Float"));
		metadata.add(new Metadata("anno2015", "Anno", "Float"));
		metadata.add(new Metadata("anno2016", "Anno", "Float"));
		metadata.add(new Metadata("anno2017", "Anno", "Float"));
		return metadata;
	}
	@Override
	public Collection<Record> filterField(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
