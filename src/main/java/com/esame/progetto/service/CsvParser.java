package com.esame.progetto.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.esame.progetto.model.Record;

/** Rappresenta la classe statica che effettua il parsing del file csv
 * e restituisce i record salvati.
**/

public class CsvParser { 
	String csvFile;
	static BufferedReader br = null;                                     
	static String line = "";
	static int row = 1;
	static ArrayList<Record> records = new ArrayList<>();
		

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


					//Il database aveva errori nella struttura, ho dovuto rimpiazzare le virgole con dei punti e virgola e siccome
					//ho bisogno di float invece che stringhe ho dovuto eliminare gli spazi in ogni campo.
					line=line.replace(',', ';').replace(" ", "");
					
					
					//Per leggere il database corretto togliere scommentare il seguente comando
					//System.out.println(line);
			        String[] recordCorrente = line.split(";");	
			 			        
			        // crea un oggetto di tipo Record
			        // elimina eventuali spazi vuoti all'inizio delle Stringhe
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
			System.out.println(e.getClass().getCanonicalName()
		    );
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName());
		}
		
		return records;
	}
}

