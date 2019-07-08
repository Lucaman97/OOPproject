package com.esame.progetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esame.progetto.database.CsvData;

@SpringBootApplication
public class ProgettoApplication {

	public static void main(String[] args) {
		CsvData.dataDownload("http://data.europa.eu/euodp/data/api/3/action/package_show?id=no3cbrttJ8NtGZIVbGnAmQ");
		SpringApplication.run(ProgettoApplication.class, args);
	}

}
