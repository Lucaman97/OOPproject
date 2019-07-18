package com.esame.progetto.model;

import java.util.ArrayList;

/** 
 * Classe i cui oggetti rappresentano le statistiche di tipo numerico.
 * Estende la superclasse Statistiche
*/

public class StatisticheNum extends Statistiche {

	// attributi
	private float avg;
	private float min;
	private float max;
	private float devStd;
	private float sum;

	public StatisticheNum(ArrayList<Record> record, String fieldName) {
		if(record.isEmpty()) {
			this.avg=0;
			this.min=0;
			this.max=0;
			this.devStd=0;
			this.sum=0;
		}
		else{
		setSum(record, fieldName);
		setAvg(record);
		setMin(record, fieldName);
		setMax(record, fieldName);
		setDevStd(record, fieldName);
		}
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(ArrayList<Record> record) {

		this.avg = this.sum / record.size();

	}

	public float getMin() {
		return min;
	}

	public void setMin(ArrayList<Record> record, String fieldName) {
		float temp, value;
		temp = (float) pickMethod(record.get(0), fieldName);
		for (int i = 1; i < record.size() - 1; i++) {
			value = (float) pickMethod(record.get(i), fieldName);
			if (value < temp)
				temp = value;
		}
		this.min = temp;

	}

	public float getMax() {
		return max;
	}

	public void setMax(ArrayList<Record> record, String fieldName) {
		float temp = 0, value = 0;
		for (int i = 0; i < record.size() - 1; i++) {
			value = (float) pickMethod(record.get(i), fieldName);
			if (value > temp)
				temp = value;
		}

		this.max = temp;

	}

	public float getDevStd() {
		return devStd;
	}

	public void setDevStd(ArrayList<Record> record, String fieldName) {
		for (int i = 0; i < record.size(); i++) {
			float temp = (float) pickMethod(record.get(i), fieldName) - getAvg();
			temp = temp * temp;
			temp = temp / record.size();
			temp = (float) Math.sqrt(temp);
			this.devStd = temp;
		}
	}

	public float getSum() {
		return sum;
	}

	public void setSum(ArrayList<Record> record, String fieldName) {
		float temp = 0;
		for (int i = 0; i < record.size(); i++) {
			temp = temp + (float) pickMethod(record.get(i), fieldName);
		}

		this.sum = temp;
	}
}