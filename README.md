# Giuoco dell'Orca
Qui ci sarà il progetto sivluppato dal gurppo Brugnola, Fasano e Meroni

REGOLAMENTO:
Il gioco è giocato da un certo numero di giocatori creati all’inizio. Ogni Giocatore è identificato
da un nome e presenta un punteggio e un carattere che funge da pedina.

Il Tabellone è composto da un insieme di caselle collegate tra loro, come fossero una lista
bidirezionale. Il numero di celle viene chiesto all’utente all’inizio del gioco.

Ogni Casella mantiene i riferimenti di quella precedente e della successiva. La Casella di
partenza, ovviamente non avrà precedente, mentre la Casella di arrivo non avrà alcuna
successiva. Ogni Casella è caratterizzata da un numero identificativo univoco che parte da 0
e da un titolo.

Ogni volta che un giocatore finisce su una Casella viene letta una domanda: nel caso dia la
risposta giusta, il giocatore riceve i punti associati alla domanda, in alternativa il suo punteggio
viene dimezzato. Nel caso in cui la risposta sia corretta, il giocatore può alterare il tabellone di
gioco spostando una casella a scelta di posizione. La quantità di spostamento (in avanti o in
dietro) è determinata dal lancio di un dado.

Ogni Domanda è a risposta chiusa: presenta un numero identificativo univoco, titolo, quattro
risposte, l’indicazione della risposta corretta, i punti relativi, proporzionali alla difficoltà e il livello
di difficoltà.
Le domande sono raccolte nel Domandiere, elemento del gioco che contiene
tutte le domande presenti e di volta in volta fornisce una tra esse. Al fine di evitare che una
stessa domanda sia ripetuta per uno stesso giocatore, ciascun giocatore mantiene la lista delle
domande assegnate. Le domande caricate nel domandiere sono prese da un file
opportunamente strutturato.

Alle caselle, in modo casuale, sono associati anche degli Imprevisti. Questi sono delle condizioni
che possono influenzare il gioco in modo positivo o negativo: aumentare/diminuire i punti, far
avanzare o retrocedere un giocatore, aumentare la difficoltà delle domande, etc.

I giocatori partono tutti dalla casella 0, con punteggio pari a 0. Ciascun giocatore tira il Dado,
che fornisce un numero casuale tra 1 e 6 e la sua pedina si sposta del numero indicato. All’arrivo
sulla Casella si leggerà la domanda e gestirà il resto in base alla correttezza o meno della
risposta; in seguito, se presente un imprevisto, questo verrà applicato.

Quando due giocatori finiscono sulla stessa Casella iniziano a lottare. La lotta consiste in tre
successivi lanci di dadi: ad ogni lancio che fa il punteggio più alto vince. Alla fine dei tre lanci il
vincitore prende i punti dell’avversario. Eventualmente potete anche inventare una modalità
di lotta differente.

Per terminare il gioco, un giocatore deve arrivare esattamente sulla casella finale. Nel caso in
cui il valore del dado superi la casella finale, il giocatore deve tornare indietro del valore in eccesso.

Il gioco termina quando un giocatore con punteggio maggiore di 0 arriva sulla casella
finale. Nel caso in cui un giocatore arriva sulla casella finale, ma ha 0 punti, viene rimandato al
Via.
