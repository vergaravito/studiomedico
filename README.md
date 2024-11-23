# Studio Medico Legale - Gestionale

Questo è un progetto di gestione per uno studio medico legale, sviluppato con **Spring Boot** per il backend e **ReactJS** per il frontend. L'applicazione consente di gestire appuntamenti, dottori, clienti (soggetti), liquidatori, assicurazioni e incarichi, e di generare documentazione PDF preformattata per ogni cliente.

## Tecnologie

- **Backend:**
  - Java 11
  - Spring Boot
  - PostgreSQL per il database

- **Frontend:**
  - ReactJS
  - Axios per la gestione delle chiamate HTTP

## Entità Principali

L'applicazione gestisce le seguenti entità:

- **Appuntamenti**: Rappresenta gli appuntamenti dei clienti con i dottori.
- **Assicurazioni**: Dettagli sulle compagnie assicurative.
- **Avvocati**: Dettagli degli avvocati coinvolti nei casi legali.
- **Dottori**: Dettagli sui dottori, che possono lavorare in più sedi.
- **Incarichi**: Assegnazione di incarichi legali e medici a dottori, avvocati, liquidatori, ecc.
- **Liquidatori**: Dettagli sui liquidatori associati alle assicurazioni.
- **Sedi**: Rappresentano le sedi degli studi medici.
- **Soggetti**: Informazioni sui clienti (soggetti), come nome, cognome, indirizzo, ecc.
- **DottoriStudi**: Associa i dottori alle sedi degli studi.

## Features

- **Gestione appuntamenti**: Gli utenti possono pianificare appuntamenti per i clienti, associando ciascun appuntamento a uno specifico dottore e studio medico.
- **Gestione soggetti**: Ogni cliente (soggetto) ha una propria scheda, con dettagli come nome, cognome, indirizzo e documenti.
- **Generazione PDF**: **TO-DO** L'app consente di generare documenti PDF preformattati con le informazioni dei clienti.
- **Gestione liquidatori e assicurazioni**: Ogni soggetto può essere associato a un assicuratore e liquidatore, facilitando la gestione delle pratiche assicurative.
- **Filtri avanzati**: I filtri per appuntamenti, dottori, e sedi possono essere facilmente configurati per ottimizzare la visualizzazione dei dati.

## Setup del Progetto

### Backend (Spring Boot)

1. **Requisiti**:
   - Java 11 o superiore
   - PostgreSQL per il database

2. **Configurazione Database**:
   - Assicurati di avere un database PostgreSQL attivo.
   - Crea un database chiamato `studio_medico`.
   - Esegui lo script SQL per creare le tabelle nel tuo database.

3. **Configurazione applicazione**:
   - Nel file `src/main/resources/application.properties`, configura la connessione al database:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/studio_medico
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

4. **Avvio del Backend**:
   - Usa il comando Maven o Gradle per avviare il progetto:
     ```bash
     mvn spring-boot:run
     ```
   - Il backend sarà disponibile su `http://localhost:8080`.

### Frontend (ReactJS)

1. **Requisiti**:
   - Node.js e npm

2. **Installazione delle dipendenze**:
   - Vai alla directory `frontend`:
     ```bash
     cd frontend
     ```
   - Installa le dipendenze:
     ```bash
     npm install
     ```

3. **Avvio del Frontend**:
   - Avvia il server di sviluppo:
     ```bash
     npm start
     ```
   - L'applicazione React sarà disponibile su `http://localhost:3000`.

### Configurazione CORS

Assicurati che il backend consenta richieste CORS dal frontend aggiungendo la configurazione necessaria nel backend Spring Boot:

```java
@CrossOrigin(origins = "http://localhost:3000")
