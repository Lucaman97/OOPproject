package com.esame.progetto.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.service.CsvParser;

public class CsvData {
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
		metadata.add(new Metadata("GEO","Geolocalita","String"));
		metadata.add(new Metadata("UNIT","Unita","String"));
		metadata.add(new Metadata("ObjectiveTimePeriod","Periodo","String"));
		return metadata;
	}
	public static void dataDownload(String urlLink) {

		try {
			  URL url = new URL(urlLink);
			  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			  BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			  String line = read.readLine();
			  String json = "";
			  try {while(line!=null) {
				  				json += line;
				  				line = read.readLine();
			  					}			  
			  					
			} catch(MalformedURLException ex) {
			 ex.printStackTrace();
			} catch(IOException ioex) {
			ioex.printStackTrace();
			}
		
			JSONObject obj = (JSONObject) JSONValue.parseWithException(json); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
		
			for(Object o: objA){
				if ( o instanceof JSONObject ) {
			    	JSONObject o1 = (JSONObject)o; 
			    	String name = (String)o1.get("name");
			    	String urlD = (String)o1.get("url");
			    	if(name.contains("CSV")) {
			        	download(urlD, "configFile/dataset.csv");
		        	}
			 	}
			}	
			
		} catch(ParseException e) {
			System.out.println(e.getClass().getCanonicalName()
				+": Errore in in com.example.demo.service.DatabaseClass.java: "
				+ "Errore nel parsing String - JsonObject");
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName()
				+": Errore in in com.example.demo.service.DatabaseClass.java: "
				+ "Controlla la validità dell URL o Verifica la tua connessione internet");
		}
	}
		
		public static void download(String url, String fileName){
			try (InputStream in = URI.create(url).toURL().openStream()) {
				Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
				records = CsvParser.csvParsing("configFile/dataset.csv");
			} catch ( Exception e) {
				//errore in scrittura
				System.out.println(e.getClass().getCanonicalName()
						+": Errore in in com.example.demo.service.DatabaseClass.java: "
						+ "Errore nella copia del File nella cartella configFile");
			}
		}
	}

