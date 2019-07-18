package com.esame.progetto.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

/**
 * Risponde alle richieste passate tramite POST o GET.
 * Per interagire con il Controller sono presenti le seguenti rotte:
 * \/data
 * \/metadata
 * \/stats
 */

@RestController
public class MainController {

	ArrayList<Metadata> metadataArr = ArrayRecords.getArrayMetadata();
	ArrayList<Record> recordArr = ArrayRecords.getRecords();
	ArrayRecords record = new ArrayRecords(recordArr);
	ArrayRecords metadata = new ArrayRecords();

	/**Richiede tutti i metadata.
	 * @return metadataArr, ritorna l'ArrayList<Metadata> che verrà interpretato
	 * e mostrato in formato json.
	 */
	@GetMapping("/metadata")
	public ArrayList<Metadata> sendMetadata() {
		return metadataArr;
	}


	/**
	 * @return metadataArr, ritorna l'ArrayList<Record> completo che verrà interpretato
	 * e mostrato in formato json.
	 */
	@GetMapping("/data")
	public ArrayList<Record> sendGetData() {

		return recordArr;
	}

	/**
	 * Funzione che riceve la richiesta POST.
	 * Filtra i dati contenuti nel body del POST e ritorna i dati filtrati che verranno
	 * interpretati e mostrati in formato json.
	 * @param bodyStr
	 * @return metadataArr, ritorna l'ArrayList<Record> che verrà interpretato
	 * e mostrato in formato json.
	 */
	@PostMapping("/data")
	public ArrayList<Record> sendPostData(@RequestBody String bodyStr) {	

		//tramite la classe JSONParser otteniamo un oggetto che scompone i vari campi della richiesta POST
		JSONParser jsonParsed = new JSONParser(bodyStr);
		String value= jsonParsed.getValue();
		String filterType = jsonParsed.getFilterType();
		ArrayList<Record> filteredRecords = new ArrayList<Record>();
		
		if (value.equals("FREQ") || value.equals("GEO") || value.equals("OBJ")) {
			
			String filterValues[]=jsonParsed.getArrayFilterVal();	
			
			//resetto record in modo che se viene effettuata una successiva richiesta non si addizionano i filtri
			filteredRecords=record.filterField(value, filterType,  filterValues);
			record = new ArrayRecords(recordArr);	
			
		} else {
			float filterValue=(float) jsonParsed.getNumFilterVal();	
			
			filteredRecords=record.filterField(value, filterType,  filterValue);
			record = new ArrayRecords(recordArr);
		}

		return filteredRecords;
	}

	
	/**Riceve il parametro via GET per le statistiche.
	 * Il parametro sarà utilizzato per decidere su quale campo effettuare le statistiche.
	 * Viene chiamato tramite una richiesta GET.
	 * @param fieldName
	 * @param value
	 * @return stat
	 * @throws ResponseStatusException
	 */
	@GetMapping("/stats")
	public Statistiche sendStats(@RequestParam(name="fieldName", defaultValue = "null") String fieldName, @RequestParam (name="value", defaultValue = "null" )String value) 
	throws ResponseStatusException
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

	

	/**
	 * Funzione che riceve la richiesta POST.
	 * Filtra i dati contenuti nel body del POST e ritorna le statistiche filtrate,
	 * interpretati e mostrati in formato json.
	 * @param bodyStr
	 * @return metadataArr, di tipo Statistiche
	 */
	@PostMapping("/stats")
	public Statistiche sendStatsFiltered(@RequestBody String bodyStr) throws ResponseStatusException {
		Statistiche stat= new Statistiche();
		
		JSONParser jsonParsed = new JSONParser(bodyStr);
		String value= jsonParsed.getValue();
		String filterType = jsonParsed.getFilterType();
		
		ArrayList<Record> filteredRecords = new ArrayList<Record>();
		
		if (value.equals("FREQ") || value.equals("GEO") || value.equals("OBJ")) {
			
			String filterValues[]=jsonParsed.getArrayFilterVal();	
			
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