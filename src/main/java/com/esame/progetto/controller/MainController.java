package com.esame.progetto.controller;



import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ArrayList<Record> sendData (@RequestParam(name="param1", defaultValue = "null") String param1) {
 		
		return recordArr;	
}
	@GetMapping("/stats")
	public Statistiche sendStats(@RequestParam String param1, @RequestParam String param2)
	{
		
		JSONObject obj = new JSONObject(param2);
		
		ArrayList<Record> filteredRecords = record.filterField("anno2000", "<", 100000000000000.0);
		stat = new Statistiche(recordArr, param1);
		return stat;	
}
	
	
	
	@PostMapping(value = "/stats")
	public Statistiche sendStatsFiltered(@RequestBody String body) 
	{

		JSONObject obj = new JSONObject(body); 
		String keys[]=JSONObject.getNames(obj);
		JSONObject subObj = new JSONObject(obj.get(keys[0]).toString());
		
		System.out.println(subObj);
		String operator="<";
		float value=100;
		
		ArrayList<Record> filteredRecords = record.filterField("anno2000", operator, value);
		stat = new Statistiche(filteredRecords, "anno2000");
		return stat;
				
		
		 
	}
}