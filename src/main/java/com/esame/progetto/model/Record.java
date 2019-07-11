package com.esame.progetto.model;
/** Rappresenta la classe i cui oggetti cotengono i dati di un 
 * record (riga) del file csv.
*/
import java.util.Arrays;
public class Record {
	
	protected String FREQ ;
	protected String GEO ;
	protected String UNIT ;
	protected String OBJ;
	protected String[] arrayAnno;
	
	public Record(String freq, String geo, String unit, String objectivetimeperiod) {

	FREQ = freq;
	GEO = geo;
	UNIT = unit;
	
	//Inserisci in una cella dell'array il valore prima del separatore, in questo caso usando ","
	//Il primo elemento dell'array sarebbe OBJ01, quindi elimino il primo elemento dell'array copiandolo prima su ObjectiveTimePeriod
	arrayAnno = objectivetimeperiod.split(",");
	OBJ= arrayAnno[0];
	arrayAnno=Arrays.copyOfRange(arrayAnno, 1, arrayAnno.length);
	
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

	public String getOBJ() {
		return OBJ;
	}

	public void setOBJ(String oBJ) {
		OBJ = oBJ;
	}
	
	public String[] getArrayAnno() {
		
		return arrayAnno;
	}

	public void setarrayAnno(String valueOTP, int position) {
		arrayAnno[position] = valueOTP;
	}
	
}
