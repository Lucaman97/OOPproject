package com.esame.progetto.controller;

import java.util.ArrayList;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esame.progetto.database.CsvData;
import com.esame.progetto.model.ArrayRecords;
import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.model.Statistiche;


@RestController
public class MainController {

	ArrayList<Metadata> metadataArr=CsvData.getArrayMetadata();
	ArrayList<Record> recordArr=CsvData.getRecords ();
	Statistiche stat;

	@GetMapping("/metadata")
	public ArrayList<Metadata> sendMetadata (@RequestParam(name="param1", defaultValue = "null") String param1) {
		return metadataArr;	
}

	@GetMapping("/data")
	public ArrayList<Record> sendData (@RequestParam(name="param1", defaultValue = "null") String param1) {
 		 return recordArr;	
}
	
	@GetMapping("/stats")
	public Statistiche sendStats (@RequestParam(name="param1", defaultValue = "null") String param1
								//,@RequestParam(name="param2", defaultValue="null") String param2
									)
	{
		stat = new Statistiche(recordArr, param1); 
		return stat;	
}

}