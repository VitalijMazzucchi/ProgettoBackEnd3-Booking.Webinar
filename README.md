Gestione Prenotazioni: (booking)

Postazione (Workstation)
 id (Entity)
    descrizione
    tipo [PRIVATO, OPENSPACE, SALA RIUNIONI]
    numero occupanti
    edificio

Edificio (Building)
 id (Entity)
    nome
    indirizzo 
    citta'
    List<Postazioni>

Utente (User)
 id (Entity)
    username
    nome completo
    email
    List<Prenotazioni>

Prenotazione (Booking)
   id (Entity)
    Postazione
    Utente
    validita'

Metodi:
	utente -> ricerca postazioni per tipo e citta'PRIVATE 

    un utente non puo prenotare piu postazioni lo stesso giorno

    se la postazioni e piena non si potra prenotare