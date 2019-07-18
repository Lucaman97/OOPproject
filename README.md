

# OOPproject

**Spring boot Web Service**

Un Web Service è un sistema software progettato per supportare l'interoperabilità tra diversi elaboratori su una medesima rete, è in grado di mettersi al servizio di un Client (applicazione, sito web, Postman) comunicando mediante il protocollo http. Consente quindi agli utenti che vi si collegano di usufruire delle funzioni che mette a disposizione. Con Spring Boot, è stato possibile creare questo software che lancia l'intera applicazione web, compreso il web server integrato.

Il nostro Data-set contiene informazioni riguardanti i **Block-exempted aid**, regolato dal GBER. Si tratta di un regolamento europeo di esenzione per categoria contenente 26 misure che possono essere utilizzate per fornire aiuti di Stato legittimi senza passare attraverso i normali processi di notifica e approvazione. È stato pubblicato dalla Commissione europea nel 2008 allo scopo di consolidare e semplificare le attuali normative sugli aiuti di Stato.

La struttura dati delle informazioni viene riassunta nello schema seguente:

((1))![](https://github.com/Lucaman97/OOPproject/blob/master/images/1.png)

La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte la:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.

Il test API è un tipo di test del software che prevede il test delle API (Application Programming Interface ) direttamente e come parte dei test di integrazione per determinare se soddisfano le aspettative in termini di funzionalità, affidabilità, prestazioni e sicurezza. Poiché le API mancano di una GUI , il test dell'API viene eseguito a livello di messaggio, nelle modalità conformi al formato standard JSON (Javascript Object Notation)

((2))

### Eseguire richieste

Per eseguire le richieste GET o POST si può installare un API testing (_ad esempio: Postman_). La seguente tabella mostra le richieste possibili.

((3))  
  
Gli oggetti presenti nei campi stringa sui quali fare le statistiche sono i seguenti:

**OBJ**:  
OBJ01, OBJ02, OBJ03, OBJ04, OBJ05, OBJ06, OBJ07, OBJ08, OBJ09, OBJ10, OBJ11, OBJ12, OBJ13 OBJ14, OBJ15, OBJ40, OBJ41, OBJ42, OTH, TOTAL

**GEO**:  
EU28, BE, BG, CZ, DK, DE, EE, IE, EL, ES, FR, HR, IT, CY, LV, LT, LU, HU, MT, NL, AT, PL, PT, RO, SI, SK, FI, SE, UK

**FREQ**:  
A

Per ottenere una statistica di tipo numerica invece è sufficiente specificare un qualsiasi numero **_facendo attenzione di metterlo in formato FLOAT_** (**_NON scrivere 100 ma 100.0_**)

La seguente tabella mostra i filtri disponibili

((4))

Per i **filtri numerici** il formato è:  
{“campo” : { “filtro” : valore_filtro}}

Per i **filtri logici** applicati a stringhe il formato è:  
{“campo” : { “filtro” : [“oggetto1”, “oggetto2”, …, “oggettoN”}

## Come avviare

### Download

Usando l’IDE Eclipse si possono seguire i seguenti passi:

-   Aprire Eclipse, nella Show view premere il pulsante "clone a Git Repository".
-   Nella finestra che appare, incollare URL di questa repository nella casella URI e procedere.
-   Recarsi nel clone della repository che apparirà, tasto destro quindi Import Project (verificare che sia importato come progetto Maven) e procedere.
-   A questo punto potete provare ad eseguire il codice, selezionando "nome_Progetto" tasto destro, "Run as" e quindi "Spring boot App".

In alternativa è possibile:

Scaricare il progetto, entrare nella directory principale con il cmd e, dopo aver installato Maven correttamente, creare il package con il comando mvn package. Per poter eseguire l’applicazione è sufficiente poi digitare da terminale

java -jar /target/”nome del file.jar”

Ora l'applicazione Web Service sarà attiva e in ascolto alla porta [http://localhost:8080](http://localhost:8080/).

## Sviluppo

### Package

((5))

### Classi

**Package com.esame.progetto**

**((6))**

**Package com.esame.progetto.controller**

((7))

**Package com.esame.progetto.model**

**((8))**

**Package com.esame.progetto.service**

**((9))**

**Package com.progetto.esame.utilities**

((10))

  

# Diagrammi UML


### Class Diagram

((11))

### Use Case Diagram

((12))

### Sequence Diagram

Run dell’Applicazione

((13))

Chiamata GET/metadata

((14))

Chiamata GET/data

((15))

Chiamata POST/data

((18))

Chiamata GET/stats

((16))

Chiamata POST/stats

((17))