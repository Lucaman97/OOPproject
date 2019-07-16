package com.esame.progetto.controller;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esame.progetto.model.ArrayRecords;
import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.model.Statistiche;
import com.esame.progetto.service.CsvParser;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class MainController {

	ArrayList<Metadata> metadataArr = ArrayRecords.getArrayMetadata();
	ArrayList<Record> recordArr = ArrayRecords.getRecords ();
	ArrayRecords record= new ArrayRecords(recordArr);
	ArrayRecords metadata= new ArrayRecords();
	Statistiche stat;

	@GetMapping("/metadata")
	public ArrayList<Metadata> sendMetadata (@RequestParam(name="param1", defaultValue = "null") String param1) {
		return metadataArr;	
}

	/**
	 * NOTA per lo sviluppatore: posso anche far ritornare recordArr e cambiare quindi il tipo a ArrayList<Record>s
	 * @param param1
	 * @return
	 */
	@GetMapping("/data") 
	public ArrayList<Record> sendData (@RequestParam(name="param1", defaultValue = "null") String param1) {
 		
		return recordArr;	
}
	@GetMapping("/stats")
	public Statistiche sendStats(@RequestParam String param1)//, @RequestParam String param2)
	{
		
	//	JSONObject obj = new JSONObject(param2);
		stat = new Statistiche(recordArr, param1);
		return stat;	
}
	
	
	
	@PostMapping(value = "/stats")
	public Statistiche sendStatsFiltered(@RequestBody String body) throws ResponseStatusException
	{
		
		String field= CsvParser.getField(body);
		ArrayList<Record> filteredRecords = CsvParser.parsingAndFiltering(record, body);
		
		// record.filterField("anno2000", operator, value);
		stat = new Statistiche(filteredRecords, field);
		
		return stat;
		
		 	
	}
}