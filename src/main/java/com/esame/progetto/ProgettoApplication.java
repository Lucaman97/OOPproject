package com.esame.progetto;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esame.progetto.service.DataFromLink;



/**
 * Effettua il download dal link e fa partire il WebService SpringBoot.
 * @author Luca Mannini
 * @author Leonardo Forcini
 * 
 */
@SpringBootApplication
public class ProgettoApplication {

	public static void main(String[] args) throws ParseException {
		DataFromLink.dataDownload("http://data.europa.eu/euodp/data/api/3/action/package_show?id=no3cbrttJ8NtGZIVbGnAmQ");
		SpringApplication.run(ProgettoApplication.class, args);
		
	}

}
