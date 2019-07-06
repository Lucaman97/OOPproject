package com.esame.progetto.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CsvData {
	public static void dataDownload(String urlLink) {
		


		try {
			  URL url = new URL(urlLink);
			  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			  BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			  String line = read.readLine();
			  String json = "";
			  while(line!=null) {
			    json += line;
			    line = read.readLine();
			  }
			  
			  System.out.println(json);
			  
			} catch(MalformedURLException ex) {
			        ex.printStackTrace();
			} catch(IOException ioex) {
			        ioex.printStackTrace();
			       
			}

	}
}
