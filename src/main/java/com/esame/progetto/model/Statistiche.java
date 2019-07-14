package com.esame.progetto.model;


import com.esame.progetto.model.Record;
import java.util.ArrayList;
import java.util.HashMap;

//import com.esame.progetto.service.Terminal;
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;





public class Statistiche {

	//attributi 
private float avg;
private float min;
private float max;
private float devStd;
private float sum;


//statistica per i campi stringa
//PROBABLY NEED TO SET IT AS AN HASHMAP, STAY TUNED
private int count;


/* 	//Provato con HashMap e LambdaExpression invece dei Switch ma dopo 5 giorni di prove inutili
 ///direi che è più semplice così

Map<String, Retriever> hashCommand = new HashMap<>();
interface Retriever {
	float retrieve();
}
*/

	//metodi
public float getAvg() {
	return avg;
}
public void setAvg(ArrayList<Record> record) 
{
	
	this.avg=this.sum/record.size();
	 
}

public float getMin() {
	return min;
}
public void setMin(ArrayList<Record> record, String fieldName) {
		float temp=0, value=0;	
	for(int i=0; i< record.size()-1; i++) {
		value=(float)pickMethod(record.get(i), fieldName);
		if(value<temp)	temp=value;
	}
	
	this.min=temp;
	
}

public float getMax() {
	return max;
}

public void setMax(ArrayList<Record> record, String fieldName) {
	float temp=0, value=0;	
for(int i=0; i< record.size()-1; i++) {
	value=(float)pickMethod(record.get(i), fieldName);
	if(value>temp)	temp = value;
}

	this.max=temp;
	

}
	
public float getDevStd() {
	return devStd;
}


public void setDevStd(ArrayList<Record> record, String fieldName) {
	for(int i=0; i<record.size(); i++)
	{
	float temp=(float)pickMethod(record.get(i), fieldName)-getAvg();
	temp=temp*temp;
	temp=temp/record.size();
	temp=(float)Math.sqrt(temp);
	this.devStd=temp;
	}
}
public float getSum() {
	return sum;
}

public void setSum(ArrayList<Record> record, String fieldName) {
	float temp=0; 
	for(int i=0; i<record.size(); i++)
	 {
		temp= temp + (float)pickMethod(record.get(i), fieldName);
	 }

	this.sum=temp;
 }


public float getCount() {
	return count;
}

public void setCount(ArrayList<Record> record, String fieldName) {
	
}
public Statistiche(ArrayList<Record> record, String fieldName) {
	
	//Method m = record.get(i).getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1), null);
	if(fieldName=="FREQ" || fieldName=="GEO" || fieldName=="OBJ")
	{
		setCount(record, fieldName);
	}
	
	setSum(record, fieldName);
	setAvg(record);
	setMin(record, fieldName);
	setMax(record, fieldName);
	setDevStd(record, fieldName);
	
	/*
	int i=0;
    Terminal commandLine = new Terminal(record.get(i));

    try {
        Object oggetto=commandLine.executeCommand("anno2000");
        System.out.println(oggetto.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
    */

	
	
  }
	
	
	

private Object pickMethod(Record r, String fieldName) {
	switch (fieldName) {
		case "anno2000":
			return r.getAnno2000();
		case "anno2001":
			return r.getAnno2001();
		case "anno2002":
			return r.getAnno2002();
		case "anno2003":
			return r.getAnno2003();
		case "anno2004":
			return r.getAnno2004();
		case "anno2005":
			return r.getAnno2005();
		case "anno2006":
			return r.getAnno2006();
		case "anno2007":
			return r.getAnno2007();
		case "anno2008":
			return r.getAnno2008();			
		case "anno2009":
			return r.getAnno2009();
		case "anno2010":
			return r.getAnno2010();
		case "anno2011":
			return r.getAnno2011();
		case "anno2012":
			return r.getAnno2012();
		case "anno2013":
			return r.getAnno2013();
		case "anno2014":
			return r.getAnno2014();
		case "anno2015":
			return r.getAnno2015();
		case "anno2016":
			return r.getAnno2016();
		case "anno2017":
			return r.getAnno2017();			
		case "FREQ":
			return r.getFREQ();
		case "GEO":
			return r.getGEO();
		case "OBJ":
			return r.getOBJ();
	
	}
	return null;
}
}