package com.esame.progetto.model;

import java.util.ArrayList;


/** 
 * Classe i cui oggetti rappresentano le statistiche di tipo numerico.
 * Estende la superclasse Statistiche
*/

public class StatisticheStr extends Statistiche {
	private int count;
	
	public StatisticheStr(ArrayList<Record> record, String fieldName, String value) {
		
		setCount(record, fieldName, value);
	}
	
	public float getCount() {
		return count;
	}

	public void setCount(ArrayList<Record> record, String fieldName, String value) {

		int temp=0;
		if(value.equals("*"))
		{
			this.count=record.size();
			return;
		}
		
		
		for(int i=0; i<record.size(); i++) {
			
			if( ((String)pickMethod(record.get(i),fieldName)).equals(value))
			{
				temp+=1;
			}
		}
		this.count=temp;
		
	}
}