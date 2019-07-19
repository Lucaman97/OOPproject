

# OOPproject

**Spring boot Web Service**

Un Web Service è un sistema software progettato per supportare l'interoperabilità tra diversi elaboratori su una medesima rete, è in grado di mettersi al servizio di un Client (applicazione, sito web, Postman) comunicando mediante il protocollo http. Consente quindi agli utenti che vi si collegano di usufruire delle funzioni che mette a disposizione. Con Spring Boot, è stato possibile creare questo software che lancia l'intera applicazione web, compreso il web server integrato.

Il nostro Data-set contiene informazioni riguardanti i **Block-exempted aid**, regolato dal GBER. Si tratta di un regolamento europeo di esenzione per categoria contenente 26 misure che possono essere utilizzate per fornire aiuti di Stato legittimi senza passare attraverso i normali processi di notifica e approvazione. È stato pubblicato dalla Commissione europea nel 2008 allo scopo di consolidare e semplificare le attuali normative sugli aiuti di Stato.

La struttura dati delle informazioni, visionabile   [cliccando qui](https://webgate.ec.europa.eu/comp/redisstat/databrowser/product/page/COMP_BEX_SA_X$COMP_BEX_SA_01), viene riassunta nello schema seguente:

![](https://github.com/Lucaman97/OOPproject/blob/master/images/1.png)

La nostra applicazione permette di richiedere mediante API REST (GET o POST) con rotte distinte la:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.

Il test API è un tipo di test del software che prevede il test delle API (Application Programming Interface ) direttamente e come parte dei test di integrazione per determinare se soddisfano le aspettative in termini di funzionalità, affidabilità, prestazioni e sicurezza. Poiché le API mancano di una GUI , il test dell'API viene eseguito a livello di messaggio, nelle modalità conformi al formato standard JSON (Javascript Object Notation)

![](#%20OOPproject%20%20**Spring%20boot%20Web%20Service**%20%20Un%20Web%20Service%20%C3%A8%20un%20sistema%20software%20progettato%20per%20supportare%20l%27interoperabilit%C3%A0%20tra%20diversi%20elaboratori%20su%20una%20medesima%20rete,%20%C3%A8%20in%20grado%20di%20mettersi%20al%20servizio%20di%20un%20Client%20%28applicazione,%20sito%20web,%20Postman%29%20comunicando%20mediante%20il%20protocollo%20http.%20Consente%20quindi%20agli%20utenti%20che%20vi%20si%20collegano%20di%20usufruire%20delle%20funzioni%20che%20mette%20a%20disposizione.%20Con%20Spring%20Boot,%20%C3%A8%20stato%20possibile%20creare%20questo%20software%20che%20lancia%20l%27intera%20applicazione%20web,%20compreso%20il%20web%20server%20integrato.%20%20Il%20nostro%20Data-set%20contiene%20informazioni%20riguardanti%20i%20**Block-exempted%20aid**,%20regolato%20dal%20GBER.%20Si%20tratta%20di%20un%20regolamento%20europeo%20di%20esenzione%20per%20categoria%20contenente%2026%20misure%20che%20possono%20essere%20utilizzate%20per%20fornire%20aiuti%20di%20Stato%20legittimi%20senza%20passare%20attraverso%20i%20normali%20processi%20di%20notifica%20e%20approvazione.%20%C3%88%20stato%20pubblicato%20dalla%20Commissione%20europea%20nel%202008%20allo%20scopo%20di%20consolidare%20e%20semplificare%20le%20attuali%20normative%20sugli%20aiuti%20di%20Stato.%20%20La%20struttura%20dati%20delle%20informazioni%20viene%20riassunta%20nello%20schema%20seguente:%20%20%28%281%29%29!%5B%5D%28https://github.com/Lucaman97/OOPproject/blob/master/images/1.png%29%20%20La%20nostra%20applicazione%20permette%20di%20richiedere%20mediante%20API%20REST%20%28GET%20o%20POST%29%20con%20rotte%20distinte%20la:%20%20-%20%20%20Restituzione%20dei%20metadati,%20formato%20JSON,%20ovvero%20l%E2%80%99elenco%20degli%20attributi,%20alias%20degli%20stessi%20e%20tipo%20di%20dati%20contenuti.%20-%20%20%20Restituzione%20dei%20dati%20riguardanti%20ogni%20record,%20formato%20JSON.%20-%20%20%20Restituzione%20dei%20dati%20riguardanti%20record%20filtrati,%20formato%20JSON.%20-%20%20%20Restituzione%20delle%20statistiche%20sui%20dati%20di%20uno%20specifico%20campo.%20-%20%20%20Restituzione%20delle%20statistiche%20sui%20dati%20di%20uno%20specifico%20campo,%20su%20record%20filtrati.%20%20Il%20test%20API%20%C3%A8%20un%20tipo%20di%20test%20del%20software%20che%20prevede%20il%20test%20delle%20API%20%28Application%20Programming%20Interface%20%29%20direttamente%20e%20come%20parte%20dei%20test%20di%20integrazione%20per%20determinare%20se%20soddisfano%20le%20aspettative%20in%20termini%20di%20funzionalit%C3%A0,%20affidabilit%C3%A0,%20prestazioni%20e%20sicurezza.%20Poich%C3%A9%20le%20API%20mancano%20di%20una%20GUI%20,%20il%20test%20dell%27API%20viene%20eseguito%20a%20livello%20di%20messaggio,%20nelle%20modalit%C3%A0%20conformi%20al%20formato%20standard%20JSON%20%28Javascript%20Object%20Notation%29%20%20%28%282%29%29%20%20###%20Eseguire%20richieste%20%20Per%20eseguire%20le%20richieste%20GET%20o%20POST%20si%20pu%C3%B2%20installare%20un%20API%20testing%20%28_ad%20esempio:%20Postman_%29.%20La%20seguente%20tabella%20mostra%20le%20richieste%20possibili.%20%20%28%283%29%29%20%20%20%20%20%20Gli%20oggetti%20presenti%20nei%20campi%20stringa%20sui%20quali%20fare%20le%20statistiche%20sono%20i%20seguenti:%20%20**OBJ**:%20%20%20OBJ01,%20OBJ02,%20OBJ03,%20OBJ04,%20OBJ05,%20OBJ06,%20OBJ07,%20OBJ08,%20OBJ09,%20OBJ10,%20OBJ11,%20OBJ12,%20OBJ13%20OBJ14,%20OBJ15,%20OBJ40,%20OBJ41,%20OBJ42,%20OTH,%20TOTAL%20%20**GEO**:%20%20%20EU28,%20BE,%20BG,%20CZ,%20DK,%20DE,%20EE,%20IE,%20EL,%20ES,%20FR,%20HR,%20IT,%20CY,%20LV,%20LT,%20LU,%20HU,%20MT,%20NL,%20AT,%20PL,%20PT,%20RO,%20SI,%20SK,%20FI,%20SE,%20UK%20%20**FREQ**:%20%20%20A%20%20Per%20ottenere%20una%20statistica%20di%20tipo%20numerica%20invece%20%C3%A8%20sufficiente%20specificare%20un%20qualsiasi%20numero%20**_facendo%20attenzione%20di%20metterlo%20in%20formato%20FLOAT_**%20%28**_NON%20scrivere%20100%20ma%20100.0_**%29%20%20La%20seguente%20tabella%20mostra%20i%20filtri%20disponibili%20%20%28%284%29%29%20%20Per%20i%20**filtri%20numerici**%20il%20formato%20%C3%A8:%20%20%20%7B%E2%80%9Ccampo%E2%80%9D%20:%20%7B%20%E2%80%9Cfiltro%E2%80%9D%20:%20valore_filtro%7D%7D%20%20Per%20i%20**filtri%20logici**%20applicati%20a%20stringhe%20il%20formato%20%C3%A8:%20%20%20%7B%E2%80%9Ccampo%E2%80%9D%20:%20%7B%20%E2%80%9Cfiltro%E2%80%9D%20:%20%5B%E2%80%9Coggetto1%E2%80%9D,%20%E2%80%9Coggetto2%E2%80%9D,%20%E2%80%A6,%20%E2%80%9CoggettoN%E2%80%9D%7D%20%20##%20Come%20avviare%20%20###%20Download%20%20Usando%20l%E2%80%99IDE%20Eclipse%20si%20possono%20seguire%20i%20seguenti%20passi:%20%20-%20%20%20Aprire%20Eclipse,%20nella%20Show%20view%20premere%20il%20pulsante%20%22clone%20a%20Git%20Repository%22.%20-%20%20%20Nella%20finestra%20che%20appare,%20incollare%20URL%20di%20questa%20repository%20nella%20casella%20URI%20e%20procedere.%20-%20%20%20Recarsi%20nel%20clone%20della%20repository%20che%20apparir%C3%A0,%20tasto%20destro%20quindi%20Import%20Project%20%28verificare%20che%20sia%20importato%20come%20progetto%20Maven%29%20e%20procedere.%20-%20%20%20A%20questo%20punto%20potete%20provare%20ad%20eseguire%20il%20codice,%20selezionando%20%22nome_Progetto%22%20tasto%20destro,%20%22Run%20as%22%20e%20quindi%20%22Spring%20boot%20App%22.%20%20In%20alternativa%20%C3%A8%20possibile:%20%20Scaricare%20il%20progetto,%20entrare%20nella%20directory%20principale%20con%20il%20cmd%20e,%20dopo%20aver%20installato%20Maven%20correttamente,%20creare%20il%20package%20con%20il%20comando%20mvn%20package.%20Per%20poter%20eseguire%20l%E2%80%99applicazione%20%C3%A8%20sufficiente%20poi%20digitare%20da%20terminale%20%20java%20-jar%20/target/%E2%80%9Dnome%20del%20file.jar%E2%80%9D%20%20Ora%20l%27applicazione%20Web%20Service%20sar%C3%A0%20attiva%20e%20in%20ascolto%20alla%20porta%20%5Bhttp://localhost:8080%5D%28http://localhost:8080/%29.%20%20##%20Sviluppo%20%20###%20Package%20%20%28%285%29%29%20%20###%20Classi%20%20**Package%20com.esame.progetto**%20%20**%28%286%29%29**%20%20**Package%20com.esame.progetto.controller**%20%20%28%287%29%29%20%20**Package%20com.esame.progetto.model**%20%20**%28%288%29%29**%20%20**Package%20com.esame.progetto.service**%20%20**%28%289%29%29**%20%20**Package%20com.progetto.esame.utilities**%20%20%28%2810%29%29%20%20%20%20%20%20#%20Diagrammi%20UML%20%20%20###%20Class%20Diagram%20%20%28%2811%29%29%20%20###%20Use%20Case%20Diagram%20%20%28%2812%29%29%20%20###%20Sequence%20Diagram%20%20Run%20dell%E2%80%99Applicazione%20%20%28%2813%29%29%20%20Chiamata%20GET/metadata%20%20%28%2814%29%29%20%20Chiamata%20GET/data%20%20%28%2815%29%29%20%20Chiamata%20POST/data%20%20%28%2818%29%29%20%20Chiamata%20GET/stats%20%20%28%2816%29%29%20%20Chiamata%20POST/stats%20%20%28%2817%29%29)

### Eseguire richieste

Per eseguire le richieste GET o POST si può installare un API testing (_ad esempio: Postman_). La seguente tabella mostra le richieste possibili.

![](https://github.com/Lucaman97/OOPproject/blob/master/images/3.png)
  
Gli oggetti presenti nei campi stringa sui quali fare le statistiche sono i seguenti:

**OBJ**:  
OBJ01, OBJ02, OBJ03, OBJ04, OBJ05, OBJ06, OBJ07, OBJ08, OBJ09, OBJ10, OBJ11, OBJ12, OBJ13 OBJ14, OBJ15, OBJ40, OBJ41, OBJ42, OTH, TOTAL

**GEO**:  
EU28, BE, BG, CZ, DK, DE, EE, IE, EL, ES, FR, HR, IT, CY, LV, LT, LU, HU, MT, NL, AT, PL, PT, RO, SI, SK, FI, SE, UK

**FREQ**:  
A

Per ottenere una statistica di tipo numerica invece è sufficiente specificare un qualsiasi numero in formato FLOAT (100.0 e non 100).

La seguente tabella mostra i filtri disponibili

![](https://github.com/Lucaman97/OOPproject/blob/master/images/4.png)

Per i **filtri numerici** il formato è: 
{“campo” : { “filtro” : valore_filtro}}  

Per i **filtri logici** applicati a stringhe il formato è: 
{“campo” : { “filtro” : [“oggetto1”, “oggetto2”, …, “oggettoN”]}}
 
Per mostrare l'intero dataset effettuare una richiesta get su /data, per i metadata su /metadata. 
 
Per mostrare le statistiche e i data non filtrati effettuare una richiesta GET con primo parametro "fieldName" e secondo "value" nel caso di valori stringhe e solo fieldName nel caso di valori numerici. 

Esempio di prova: 

Valori stringa
GET localhost:8080/stats?fieldName=GEO&value=UK 
GET localhost:8080/data?fieldName=GEO&value=IT 
Valori numerici 
GET localhost:8080/stats?fieldName=anno2015 
GET localhost:8080/data?fieldName=anno2014
 

Infine per filtrare su /data e /stats fare una richiesta POST con il filtro specificato nel body. 
Esempi di prova: 

POST localhost:8080/stats body={"anno2010": {"$gt" : 140.0}}
POST localhost:8080/stats body={"GEO" : {"$in": ["UK", "DK", "SE"]}}
POST localhost:8080/data body={"anno2012": {"$lt" : 550.0}}
POST localhost:8080/data body={"OBJ" : {"$nin": ["OBJ01", "OBJ04]}}
 

## Come avviare

### Download

Usando l’IDE Eclipse si possono seguire i seguenti passi:

-   Aprire Eclipse, nella Show view premere il pulsante "clone a Git Repository".
-   Nella finestra che appare, incollare URL di questa repository nella casella URI e procedere.
-   Recarsi nel clone della repository che apparirà, tasto destro quindi Import Project (verificare che sia importato come progetto Maven) e procedere.
-   A questo punto potete provare ad eseguire il codice, selezionando "nome_Progetto" tasto destro, "Run as" e quindi "Spring boot App".

In alternativa è possibile:

Scaricare il progetto, entrare nella directory principale da terminale e, dopo aver installato Maven correttamente, creare il package con il comando "mvn package". Per poter eseguire l’applicazione è sufficiente poi digitare da terminale:

”java -jar /target/”nome del file.jar”

Ora l'applicazione Web Service sarà attiva e in ascolto alla porta [http://localhost:8080](http://localhost:8080/).

## Sviluppo

### Package

![](https://github.com/Lucaman97/OOPproject/blob/master/images/5.png)

### Classi

**Package com.esame.progetto**

**![](https://github.com/Lucaman97/OOPproject/blob/master/images/6.png)**

**Package com.esame.progetto.controller**

![](https://github.com/Lucaman97/OOPproject/blob/master/images/7.png)

**Package com.esame.progetto.model**

**![](https://github.com/Lucaman97/OOPproject/blob/master/images/8.png)**

**Package com.esame.progetto.service**

**![](https://github.com/Lucaman97/OOPproject/blob/master/images/9.png)**

**Package com.progetto.esame.utilities**

![](https://github.com/Lucaman97/OOPproject/blob/master/images/10.png)

  

# Diagrammi UML


### Class Diagram

![](https://github.com/Lucaman97/OOPproject/blob/master/images/11.png)

### Use Case Diagram

![](https://github.com/Lucaman97/OOPproject/blob/master/images/12.png)

### Sequence Diagram

Run dell’Applicazione

![](https://github.com/Lucaman97/OOPproject/blob/master/images/13.jpg)

Chiamata GET/metadata

![](https://github.com/Lucaman97/OOPproject/blob/master/images/14.jpg)

Chiamata GET/data

![](https://github.com/Lucaman97/OOPproject/blob/master/images/15.jpg)

Chiamata GET/stats

![](https://github.com/Lucaman97/OOPproject/blob/master/images/16.jpg)

Chiamata POST/data

![](https://github.com/Lucaman97/OOPproject/blob/master/images/17.jpg)

Chiamata POST/stats

![](https://github.com/Lucaman97/OOPproject/blob/master/images/18.jpg)
