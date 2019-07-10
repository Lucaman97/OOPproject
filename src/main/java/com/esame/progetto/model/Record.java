package com.esame.progetto.model;
/** Rappresenta la classe i cui oggetti cotengono i dati di un 
 * record (riga) del file csv.
*/

public class Record {
	
	protected String FREQ ;
	protected String GEO ;
	protected String UNIT ;
	protected String ObjectiveTimePeriod[];
	
	public Record(String freq, String geo, String unit, String objectivetimeperiod) {

	FREQ = freq;
	GEO = geo;
	UNIT = unit;
	
	//Inserisci in una cella dell'array il valore prima del separatore, in questo caso usando ","
	ObjectiveTimePeriod = objectivetimeperiod.split(",");
	}

	public String getFREQ() {
		return FREQ;
	}

	public void setFREQ(String fREQ) {
		FREQ = fREQ;
	}

	public String getGEO() {
		return GEO;
	}

	public void setGEO(String gEO) {
		GEO = gEO;
	}

	public String getUNIT() {
		return UNIT;
	}

	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}
	
	public String[] getObjectiveTimePeriod() {
		
		return ObjectiveTimePeriod;
	}

	public void setObjectiveTimePeriod(String valueOTP, int position) {
		ObjectiveTimePeriod[position] = valueOTP;
	}
	
}
