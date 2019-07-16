package com.esame.progetto.controller;

import java.util.ArrayList;

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
import com.esame.progetto.service.CsvParser;

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
		value=value.toUpperCase();
		fieldName=fieldName.toUpperCase();
		if(fieldName.equals("null")) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Devi passare un parametro fieldName per ottenerne le statistiche.");
		else if (fieldName.equals("FREQ") || fieldName.equals("GEO") || fieldName.equals("OBJ")) {
			stat = new StatisticheStr(recordArr, fieldName, value);
		} else {
			stat = new StatisticheNum(recordArr, fieldName);
		}

		return stat;
	}
/*
	@PostMapping("/stats")
	public Statistiche sendStatsFiltered(@RequestBody JSONObject body) throws ResponseStatusException {

		String fieldName = CsvParser.getField(body);
		Statistiche stat;

		fieldName=fieldName.toUpperCase();
		if (fieldName.equals("FREQ") || fieldName.equals("GEO") || fieldName.equals("OBJ")) {
			stat = new StatisticheStr(recordArr, fieldName, value);
		} else {
			ArrayList<Record> filteredRecords = CsvParser.parsingAndFiltering(record, body);
			stat = new StatisticheNum(filteredRecords, fieldName);
		}

		return stat;

	}
	*/
}