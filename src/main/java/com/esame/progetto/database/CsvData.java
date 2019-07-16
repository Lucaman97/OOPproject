package com.esame.progetto.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
//import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.service.CsvParser;

public class CsvData {
	private final static String ADDRESS_FILE="configFile/dataset.csv";
	static ArrayList<Record> records;
	static ArrayList<Metadata> metadata;
	
	public static void dataDownload(String urlLink) throws ParseException {

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

			JSONObject obj = new JSONObject(json); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));

			
			for(Object o: objA){
				if ( o instanceof JSONObject ) {
			    	JSONObject o1 = (JSONObject)o; 
			    	String name = (String)o1.get("name");
			    	String urlD = (String)o1.get("url");
			    	if(name.contains("CSV")) {
			        	download(urlD, ADDRESS_FILE);
		        	}
			 	}
			}	
			
		} catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName());
		}
		finally {
			//VERY IMPORTANT
			records = CsvParser.csvParsing(ADDRESS_FILE);
			metadata = CsvParser.getArrayMetadata();
		}
	}
		
	
	
	
		public static void download(String url, String fileName){
			try (InputStream in = URI.create(url).toURL().openStream()) {
				Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
				
			} catch ( Exception e) {
				//errore in scrittura
				System.out.println(e.getClass().getCanonicalName());
			}
		}
		
		public static ArrayList<Record> getRecords()
		{
			return records;
		}
		
		public static ArrayList<Metadata> getArrayMetadata() {
			return metadata;
		}
	}

