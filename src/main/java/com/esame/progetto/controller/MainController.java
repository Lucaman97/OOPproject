package com.esame.progetto.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esame.progetto.model.ArrayRecords;
import com.esame.progetto.model.Metadata;
import com.esame.progetto.model.Record;
import com.esame.progetto.model.Statistiche;
import com.esame.progetto.model.StatisticheNum;
import com.esame.progetto.model.StatisticheStr;
import com.esame.progetto.service.JSONParser;

@RestController
public class MainController {

	ArrayList<Metadata> metadataArr = ArrayRecords.getArrayMetadata();
	ArrayList<Record> recordArr = ArrayRecords.getRecords();
	ArrayRecords record = new ArrayRecords(recordArr);
	ArrayRecords metadata = new ArrayRecords();

	@GetMapping("/metadata")
	public ArrayList<Metadata> sendMetadata(@RequestParam(name = "param1", defaultValue = "null") String param1) {
		return metadataArr;
	}

	/**
	 * NOTA per lo sviluppatore: posso anche far ritornare recordArr e cambiare
	 * quindi il tipo a ArrayList<Record>s
	 * 
	 * @param param1
	 * @return
	 */
	@GetMapping("/data")
	public ArrayList<Record> sendData(@RequestParam(name = "param1", defaultValue = "null") String param1) {

		return recordArr;
	}

	@GetMapping("/stats")
	public Statistiche sendStats(@RequestParam(name="fieldName", defaultValue = "null") String fieldName, @RequestParam (name="value", defaultValue = "null" )String value) throws ResponseStatusException
	{
		Statistiche stat;
		if(fieldName.equals("null")) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Devi passare un parametro fieldName per ottenerne le statistiche.");
		else if (fieldName.equals("FREQ") || fieldName.equals("GEO") || fieldName.equals("OBJ")) 
		{
			stat = new StatisticheStr(recordArr, fieldName, value);
		} else {
			stat = new StatisticheNum(recordArr, fieldName);
		}

		return stat;
	}

	@PostMapping("/stats")
	public Statistiche sendStatsFiltered(@RequestBody String bodyStr) throws ResponseStatusException {
		Statistiche stat= new Statistiche();
		JSONParser jsonParsed = new JSONParser(bodyStr);
		String value= jsonParsed.getValue();
		String filterType = jsonParsed.getFilterType();
		ArrayList<Record> filteredRecords = new ArrayList<Record>();
		
		/*
		String fieldName=jsonParsed.getCampoStat().toUpperCase();
		String value=jsonParsed.getValore();
		
		
		String chiaveFiltri[] = jsonParsed.getChiaveFiltri();
		String tipoFiltri[] = jsonParsed.getTipoFiltri();
		String valFiltri[] = jsonParsed.getValFiltri();
		
		System.out.println(Arrays.toString(chiaveFiltri) + " " + Arrays.toString(tipoFiltri) + " " + Arrays.toString(valFiltri));
		ArrayList<Record> filteredRecords = new ArrayList<Record>();

		System.out.println(chiaveFiltri.length);
		System.out.println(chiaveFiltri[0] + " "+ tipoFiltri[0] + " " + valFiltri[0]);
		for(int i=0; i<chiaveFiltri.length; i++)
		{
			filteredRecords=record.filterField(chiaveFiltri[i], tipoFiltri[i], valFiltri[i]);
			record = new ArrayRecords(filteredRecords);
		}
		System.out.println(filteredRecords.size());
		
		*/
		if (value.equals("FREQ") || value.equals("GEO") || value.equals("OBJ")) {
			
			String filterValues[]=jsonParsed.getArrayFilterVal();	
			System.out.println(value + " "+ filterType + " " + Arrays.toString(filterValues));
			
			filteredRecords=record.filterField(value, filterType,  filterValues);
			record = new ArrayRecords(recordArr);
			
			stat = new StatisticheStr(filteredRecords, value, "*");
		} else {
			float filterValue=(float) jsonParsed.getNumFilterVal();	
			filteredRecords=record.filterField(value, filterType,  filterValue);
			record = new ArrayRecords(recordArr);
			stat = new StatisticheNum(filteredRecords, value);
		}

		return stat;

	}
	
}