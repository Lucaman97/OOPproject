package com.esame.progetto.model;

import java.util.ArrayList;

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
		
		
		for(int i=0; i<record.size(); i++) {
			
			if( ((String)pickMethod(record.get(i),fieldName)).equals(value))
			{
				temp+=1;
			}
		}
		this.count=temp;
		
	}
}