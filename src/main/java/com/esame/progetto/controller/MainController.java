package com.esame.progetto.controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.esame.progetto.model.ArrayRecords;
import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.model.Statistiche;




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
	public ArrayRecords sendData (@RequestParam(name="param1", defaultValue = "null") String param1) {
 		
		return record;	
}
	@GetMapping("/stats")
	public Statistiche sendStats(@RequestParam String param1)
	{

		stat = new Statistiche(recordArr, param1);
		return stat;	
}
	
	@PostMapping("/stats")
	public Statistiche sendStatsFiltered(@RequestBody String body, 
										@RequestParam(name="param1", defaultValue ="anno2000") String param1) 
										throws ParseException
	{
		//JSONObject obj = (JSONObject) JSONValue.parseWithException(body);
		
		ArrayList<Record> filteredRecords = record.filterField("anno2000", "<", 1000.0);
		stat = new Statistiche(filteredRecords, param1);
		return stat;
			
}

}