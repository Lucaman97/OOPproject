package com.esame.progetto.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.progetto.database.CsvData;
import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;

@RestController
public class MainController {

	ArrayList<Metadata> metadataView=CsvData.getArrayMetadata ();
	ArrayList<Record> recordView=CsvData.getRecords ();
	
	@GetMapping("/metadata")
	public ArrayList<Metadata> sendMetadata (@RequestParam(name="param1", defaultValue="No data available") String param1) {
 		 return metadataView;	
}

	@GetMapping("/data")
	public ArrayList<Record> sendData (@RequestParam(name="param1", defaultValue="No data available") String param1) {
 		 return CsvData.getRecords ();	
}
}