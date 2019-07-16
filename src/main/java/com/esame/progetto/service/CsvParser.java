package com.esame.progetto.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.esame.progetto.model.*;
/** Rappresenta la classe statica che effettua il parsing del file csv
 * e restituisce i record salvati.
**/

public class CsvParser { 
	String csvFile;
	static BufferedReader br = null;                                     
	static String line = "";
	static int row = 1;
	static ArrayList<Record> records = new ArrayList<>();
	static ArrayList<Metadata> metadata= new ArrayList<>();

	/**
	 * Effettua il parsing del file CSV, salvando ogni riga come oggetto Record.
	 * @param csvFile il nome (compreso percorso cartella), del file in cui effettuare le operazioni.
	 * @return L' intero ArrayList di Record.
	*/
	
	public static ArrayList<Record> csvParsing(String csvFile){
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			br.readLine(); // legge la prima riga e la ignora
			
			while ((line = br.readLine()) != null) {	
				
				try {


					/**Il database ha errori nella struttura, ho dovuto rimpiazzare le virgole con dei punti e virgola e siccome
					 * ho bisogno di float invece che stringhe ho dovuto eliminare gli spazi in ogni campo.
					 */
					line=line.replace(',', ';').replace(" ", "");
					
					
					/**Per leggere il database corretto togliere scommentare il seguente comando
					 * System.out.println(line);
					 */
			        String[] recordCorrente = line.split(";");	
			 			        
			        /** crea un oggetto di tipo Record
			         * elimina eventuali spazi vuoti all'inizio delle Stringhe
			         * 
			         */
			        Record oggettoRecord = new Record(
			        							recordCorrente[0],		
			        							recordCorrente[1],		
			        							recordCorrente[2],		
			        							recordCorrente[3],		
			        							Float.valueOf(recordCorrente[4]),		
			        							Float.valueOf(recordCorrente[5]),		
			        							Float.valueOf(recordCorrente[6]),		
			        							Float.valueOf(recordCorrente[7]),		
			        							Float.valueOf(recordCorrente[8]),		
			        							Float.valueOf(recordCorrente[9]),		
			        							Float.valueOf(recordCorrente[10]),		
			        							Float.valueOf(recordCorrente[11]),		
			        							Float.valueOf(recordCorrente[12]),		
			        							Float.valueOf(recordCorrente[13]),		
			        							Float.valueOf(recordCorrente[14]),		
			        							Float.valueOf(recordCorrente[15]),		
			        							Float.valueOf(recordCorrente[16]),		
			        							Float.valueOf(recordCorrente[17]),		
			        							Float.valueOf(recordCorrente[18]),		
			        							Float.valueOf(recordCorrente[19]),		
			        							Float.valueOf(recordCorrente[20]),		
			        							Float.valueOf(recordCorrente[21])
			        							
					);
			        
			        records.add(oggettoRecord);
			        
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Row #"+row+"  "+e.toString()
									  +" parametri inseriti. Aspettati 9");
				} catch(NumberFormatException e) {
					System.out.println("Row #"+row+"  "+e.toString());
				} 
				row++;
			}
	     
			try {
				br.close();
	        } catch (IOException e) {
	        	System.out.println(e.getClass().getCanonicalName()
	    	        	+"Errore in in com.example.demo.service.ParseCsv.java: Chiusura File");
	    	        }
	       
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getClass().getCanonicalName());
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName());
		}
		
		return records;
	}
	public static ArrayList<Metadata> getArrayMetadata() {
		
		metadata.add(new Metadata("FREQ","Frequenza","String"));
		metadata.add(new Metadata("GEO","Geolocalità","String"));
		metadata.add(new Metadata("UNIT","Unita","String"));
		metadata.add(new Metadata("OBJ","Periodo","String"));
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
	
	
	public static ArrayList<Record> parsingAndFiltering(ArrayRecords filteringRecords, String json){
		ArrayList<Record> filtered = new ArrayList<Record>();
		Record forTesting = new Record();
		JSONObject obj = new JSONObject(json); 
		String keys[]=JSONObject.getNames(obj);
		if(Statistiche.pickMethod(forTesting,  keys[0]) == null) {
		//System.out.println(obj.toString() + " " + keys[0]);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Il campo selezionato non esiste");
		}

		JSONObject subObj = new JSONObject(obj.get(keys[0]).toString());
		
		String subKeys[]=JSONObject.getNames(subObj);
		
		filtered =filteringRecords.filterField(keys[0],subKeys[0], subObj.get(subKeys[0]));
		
		
		return filtered;
		 
		 
	}
	public static String getField(String body) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject(body); 
		String keys[]=JSONObject.getNames(obj);
		
		return keys[0];
	}
}

