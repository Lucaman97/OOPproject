package com.esame.progetto.model;

import com.esame.progetto.utilities.*;


/** Rappresenta la classe i cui oggetti cotengono i dati di un 
 * record (riga) del file csv.
*/

public class Record //implements Filter<Record>
{
	
	protected String FREQ ;
	protected String GEO ;
	protected String UNIT ;
	protected String OBJ;
	protected float anno2000;
	protected float anno2001;
	protected float anno2002;
	protected float anno2003;
	protected float anno2004;
	protected float anno2005;
	protected float anno2006;
	protected float anno2007;
	protected float anno2008;
	protected float anno2009;
	protected float anno2010;
	protected float anno2011;
	protected float anno2012;
	protected float anno2013;
	protected float anno2014;
	protected float anno2015;
	protected float anno2016;
	protected float anno2017;
	
	public Record(
			String freq, String geo, String unit, String objectivetimeperiod,
			float argAnno2000, float argAnno2001, float argAnno2002, float argAnno2003,
			float argAnno2004, float argAnno2005, float argAnno2006, float argAnno2007,
			float argAnno2008, float argAnno2009, float argAnno2010, float argAnno2011,
			float argAnno2012, float argAnno2013, float argAnno2014, float argAnno2015,
			float argAnno2016, float argAnno2017
			) {

	FREQ = freq;
	GEO = geo;
	UNIT = unit;
	OBJ=objectivetimeperiod;
	anno2000 = argAnno2000;
	anno2001 = argAnno2001;
	anno2002 = argAnno2002;
	anno2003 = argAnno2003;
	anno2004 = argAnno2004;
	anno2005 = argAnno2005;
	anno2006 = argAnno2006;
	anno2007 = argAnno2007;
	anno2008 = argAnno2008;
	anno2009 = argAnno2009;
	anno2010 = argAnno2010;
	anno2011 = argAnno2011;
	anno2012 = argAnno2012;
	anno2013 = argAnno2013;
	anno2014 = argAnno2014;
	anno2015 = argAnno2015;
	anno2016 = argAnno2016;
	anno2017 = argAnno2017;
	
	//Inserisci in una cella dell'array il valore prima del separatore, in questo caso usando ","
	//Il primo elemento dell'array sarebbe OBJ01, quindi elimino il primo elemento dell'array copiandolo prima su ObjectiveTimePeriod
	
	}

	public Record() {
		// TODO Auto-generated constructor stub
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

	public float getAnno2000() {
		return anno2000;
	}

	public void setAnno2000(float anno2000) {
		this.anno2000 = anno2000;
	}

	public float getAnno2001() {
		return anno2001;
	}

	public void setAnno2001(float anno2001) {
		this.anno2001 = anno2001;
	}

	public float getAnno2002() {
		return anno2002;
	}

	public void setAnno2002(float anno2002) {
		this.anno2002 = anno2002;
	}

	public float getAnno2003() {
		return anno2003;
	}

	public void setAnno2003(float anno2003) {
		this.anno2003 = anno2003;
	}

	public float getAnno2004() {
		return anno2004;
	}

	public void setAnno2004(float anno2004) {
		this.anno2004 = anno2004;
	}

	public float getAnno2005() {
		return anno2005;
	}

	public void setAnno2005(float anno2005) {
		this.anno2005 = anno2005;
	}

	public float getAnno2006() {
		return anno2006;
	}

	public void setAnno2006(float anno2006) {
		this.anno2006 = anno2006;
	}

	public float getAnno2007() {
		return anno2007;
	}

	public void setAnno2007(float anno2007) {
		this.anno2007 = anno2007;
	}

	public float getAnno2008() {
		return anno2008;
	}

	public void setAnno2008(float anno2008) {
		this.anno2008 = anno2008;
	}

	public float getAnno2009() {
		return anno2009;
	}

	public void setAnno2009(float anno2009) {
		this.anno2009 = anno2009;
	}

	public float getAnno2010() {
		return anno2010;
	}

	public void setAnno2010(float anno2010) {
		this.anno2010 = anno2010;
	}

	public float getAnno2011() {
		return anno2011;
	}

	public void setAnno2011(float anno2011) {
		this.anno2011 = anno2011;
	}

	public float getAnno2012() {
		return anno2012;
	}

	public void setAnno2012(float anno2012) {
		this.anno2012 = anno2012;
	}

	public float getAnno2013() {
		return anno2013;
	}

	public void setAnno2013(float anno2013) {
		this.anno2013 = anno2013;
	}

	public float getAnno2014() {
		return anno2014;
	}

	public void setAnno2014(float anno2014) {
		this.anno2014 = anno2014;
	}

	public float getAnno2015() {
		return anno2015;
	}

	public void setAnno2015(float anno2015) {
		this.anno2015 = anno2015;
	}

	public float getAnno2016() {
		return anno2016;
	}

	public void setAnno2016(float anno2016) {
		this.anno2016 = anno2016;
	}

	public float getAnno2017() {
		return anno2017;
	}

	public void setAnno2017(float anno2017) {
		this.anno2017 = anno2017;
	}

}
