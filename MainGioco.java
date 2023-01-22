import java.io.IOException;
import java.util.Random;

public class MainGioco
{
	static Giocatore g1;
	static Giocatore g2;
	static Dado dado = new Dado();
	
	public static void main(String[] args) throws IOException
	{
		//variabili generali:
		Tabellone t = new Tabellone();
		Domandiere d = new Domandiere();
		Imprevisti i = new Imprevisti();
		
		//inizializzazione globale 
		d.leggiFile();
		//////////////////////////
		creaCaselle(t);
		//////////////////////////
		i.leggiFile();
		//////////////////////////
		menu(t, d, i);
		
	}
	
	static void menu(Tabellone t, Domandiere d, Imprevisti i)
	{
		int tastoPremuto;
		
		System.out.println("Benvenuto nel GIUOCO DELL'ORCA");
		System.out.println("Premi 1 per il tutorial");
		System.out.println("Premi 2 per giocare - sara' necessario creare i due giocatori");
		System.out.println("Premi 0 per uscire dal gioco");
		
		do {
			tastoPremuto = Leggi.unInt();
			
			switch(tastoPremuto) {
				case 1: tutorial(); break;
				case 2: gioco(t, d, dado, i); break;
				case 0: System.exit(0);
				default: break;
			}
			
		}while(tastoPremuto <1 || tastoPremuto>2);
			
	}
	
	static void inserimentoGiocatori(Tabellone t)
	{
		g1 = generalita(t);
		g2 = generalita(t);

		g1.setPosizione(t.primo.getPosizione());
		g2.setPosizione(t.primo.getPosizione());

		System.out.print("Bene! Ora sei pronto!\n");
	}
	
	public static Giocatore generalita(Tabellone t)
	{
		System.out.flush();//pulisce lo schermo
		String nome = "";
		char pedina = ' ';
		
		System.out.println("Inserisci il nome del giocatore: ");
		do{
		nome = Leggi.unoString();
		}while(nome.isEmpty());
		
		System.out.println("Inserisci la pedina del giocatore: ");
		do{
			pedina = Leggi.unChar();
		}while(pedina == ' ');
		
		Giocatore g = new Giocatore(nome, pedina, t);
		
		return g;
	}
	
	static void tutorial()
	{
		System.out.flush();//pulisce lo schermo
		//stampa il tutorial, si può pensare di mettere un file di testo e leggerlo cosi, senza fare println
	}
	
	static void gioco(Tabellone t, Domandiere d, Dado dado, Imprevisti i)
	{
		boolean fine = false;
		Random rand = new Random();
		
		do{
			inserimentoGiocatori(t);
		}while(g1 == null);
		
		while(!fine)
		{
			// 	TODO:
			/*
			 * controlare stampa tabella - sistemare condizioni - vedi file su git - non stampa la 19 
			 * spostamento di una casella - controlla e sistema
			 * trovare un modo per cancellare la console di eclipse - IMPORTANTE!!
			 * 
			 */
			
			
			/////////////////////////////////////////////////////////
			turno(g1, t);
			if(!controllaImprevisti(t, g1))
				domandeAlGiocatore(g1, d);
			else {
				System.out.println("Sei caduto su un IMPREVISTO!");
				i.getImprevisto((int) (rand.nextInt(4))+1, g1);
			}
			/////////////////////////////////////////////////////////
			turno(g2, t);
			if(!controllaImprevisti(t, g2))
				domandeAlGiocatore(g2, d);
			else {
				System.out.println("Sei caduto su un IMPREVISTO!");
				i.getImprevisto((int) (rand.nextInt(4))+1, g2);
			}
			///////////////////////////////////////////////////////////
			
			if(g1.getPosizione().equals(g2.getPosizione()))
			{
				System.out.println("ATTENZONE!\nI voi due giocatori siete finiti sulla stessa casella...");
				lotta();
			}
			
			//////////////////////////////////////////////////////////
			stampaTab(t);
			//////////////////////////////////////////////////////////
			
			if(g1.getPosizione().equals(t.getUltimo()))
			{
				System.out.println(g1.getNome()+"HAI VINTO! COMPLIMENTI!");
				fine = true;
			}
			else if(g2.getPosizione().equals(t.getUltimo()))
			{
				System.out.println(g2.getNome()+"HAI VINTO! COMPLIMENTI!");
				fine = true;
			}
		}
	}
	
	static boolean controllaImprevisti(Tabellone t, Giocatore g)
	{
		if(g.getPosizione().equals(t.casellaIn(4))
			|| g.getPosizione().equals(t.casellaIn(17))	
			|| g.getPosizione().equals(t.casellaIn(7))
			|| g.getPosizione().equals(t.casellaIn(14))	
			|| g.getPosizione().equals(t.casellaIn(10))	
			|| g.getPosizione().equals(t.casellaIn(11)))
			return true;
		else
			return false;
	}
	
	static void stampaTab(Tabellone t)
	{
		System.out.println();
				
		for(int i=0; i<t.getLunghezza(); i++)
		{
			System.out.print("\n  __    __    __    __    __    __  \n");
			
			if(g1.getPosizione() == g2.getPosizione())	
				System.out.print("  "+g1.getPedina()+g2.getPedina()+"  ");	
			if(t.casellaIn(i).equals(t.getUltimo()))
			{
				System.out.printf("|.%d.|", t.getUltimo().getPosizione());
				break;
			}
			if(g1.getPosizione() == t.casellaIn(i))
				System.out.print("  "+g1.getPedina()+"   ");
			else if(g2.getPosizione() == t.casellaIn(i))
				System.out.print("  "+g2.getPedina()+"   ");
			else if(i>9)
				System.out.printf("|.%d.|", i);
			else if(i<=9)
				System.out.printf("|.%d. |", i);
			
		}
		
		System.out.println();
	}
	
	static void turno(Giocatore g, Tabellone t)
	{
		//////////////////////////////////////////////////////////////////////////////////////////////////
		char azione = ' ';
		int tempDado;
		int tempPos = g.getPosInt();
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Turno di "+g.getNome()+": ");
		System.out.println("Premi 'd' per lanciare il dado\nPremi 'p' per sapere il tuo punteggio");

		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		do{
			azione = Leggi.unChar();
			
			if(azione == 112)
				System.out.println("Il tuo punteggio e': "+g.getPunteggio()+"\nSelezione:");
			
		}while(azione != 100);
		
		tempDado = dado.lancia();
		
		System.out.println("E' uscito il numero: "+tempDado);
	
		g.setPosizione(tempDado-1);//-2 forse
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		if(g.getPosInt() > t.getUltimo().getPosizione())
		{
			System.out.println("Sei andato oltre l'ultima cella... tornerai alla cella di prima");
			g.setPosizione(tempPos);
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Vuoi spostare una casella? - non puoi spostare la prima e l'ultima\nPremi 's' per confermare, 'e' per non spostare niente");
		azione = ' ';
		do{
			azione = Leggi.unChar();
			
			if(azione == 's')
			{
				System.out.println("Premi 'd' per tirare il dado, determinerà di quanto spostare la casella");
				azione = ' ';
				do{
					azione = Leggi.unChar();
				}while(azione != 100);
				
				tempDado = dado.lancia();
				System.out.println("E' uscito il numero: "+tempDado);
				
				System.out.println("Premi 'a' per per spostare avanti la casella, 'i' per spostarla indietro");
				azione = ' ';
				do{
					azione = Leggi.unChar();
					if(azione == 'a') {
						t.sposta(tempDado, g.getPosizione(), true); break;}
					else if(azione == 'i') {
						t.sposta(tempDado, g.getPosizione(), false); break;}
				}while(azione != 97 || azione != 105);
				
			}
			else
				break;
			
		}while(azione != 's' || azione != 'e');
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	static void domandeAlGiocatore(Giocatore g, Domandiere d)
	{
		System.out.println(g.getNome()+", ora devi rispodere a questa domanda: ");
		System.out.println(d.getDomanda(g.getPosInt()));
		
		char risposta;
		
		do {
			risposta = Leggi.unChar();
		}while(risposta<97 || risposta>99);
		
		if(risposta == d.getRisposta(g.getPosInt()))
		{
			System.out.println("CORRETTO! Hai guadagnato dei punti!");
			g.setPunteggio(3);
			g.setDomandeFatte(d.getDomanda(g.getPosInt()));
		}
		else
		{
			System.out.println("SBAGLIATO! Hai perso dei punti!");
			g.setPunteggio(-2);
			g.setDomandeFatte(d.getDomanda(g.getPosInt()));
		}
		
	}
	
	static void lotta()
	{
		System.out.println("PREPARATEVI A LOTTARE!");
		
		char lancioDado =  ' ';
		int tempDadoG1;
		int tempDadoG2;
		
		System.out.println("Turno di "+g1.getNome()+": ");
		System.out.println("Premi 'd' per lanciare il dado!");
		
		do{
			lancioDado = Leggi.unChar();
		}while(lancioDado != 100);
		
		tempDadoG1 = dado.lancia();
		System.out.println("E' uscito il numero: "+tempDadoG1);
		
		System.out.println("Turno di "+g2.getNome()+": ");
		System.out.println("Premi 'd' per lanciare il dado!");
		
		do{
			lancioDado = Leggi.unChar();
		}while(lancioDado != 100);
		
		tempDadoG2 = dado.lancia();
		System.out.println("E' uscito il numero: "+tempDadoG2);
		
		if(tempDadoG1 > tempDadoG2)
		{
			System.out.println(g1.getNome() + ", HAI VINTO!\n Ti verranno aggiunti 10 punti!");
			g1.setPunteggio(10);
			System.out.println(g2.getNome() + ", mi spiace, hai perso, ti verrano tolti 12 punti");
			g2.setPunteggio(-12);
			
		}
		else if(tempDadoG1 < tempDadoG2)
		{
			System.out.println(g2.getNome() + ", HAI VINTO!\n Ti verranno aggiunti 10 punti!");
			g2.setPunteggio(10);
			System.out.println(g1.getNome() + ", mi spiace, hai perso, ti verrano tolti 12 punti");
			g1.setPunteggio(-12);
		}
		else if(tempDadoG1 == tempDadoG2)
		{
			System.out.println("INCREDIBILE, avete fatto lo stesso numero!...");
			lotta();
		}
		
		System.out.println("... Alla prossima!");
	}

	static void creaCaselle(Tabellone t)
	{
		Casella uno = new Casella(1, null, null);
		t.inserisciPrimo(uno);
		Casella due = new Casella(2, null, null);
		t.inserisciCasella(due);
		Casella tre = new Casella(3, null, null);
		t.inserisciCasella(tre);
		Casella quattro = new Casella(4, null, null);
		t.inserisciCasella(quattro);
		Casella cinque = new Casella(5, null, null);
		t.inserisciCasella(cinque);
		Casella sei = new Casella(6, null, null);
		t.inserisciCasella(sei);
		Casella sette = new Casella(7, null, null);
		t.inserisciCasella(sette);
		Casella otto = new Casella(8, null, null);
		t.inserisciCasella(otto);
		Casella nove = new Casella(9, null, null);
		t.inserisciCasella(nove);
		Casella dieci = new Casella(10, null, null);
		t.inserisciCasella(dieci);
		Casella unidici = new Casella(11, null, null);
		t.inserisciCasella(unidici);
		Casella dodici = new Casella(12, null, null);
		t.inserisciCasella(dodici);
		Casella tredici = new Casella(13, null, null);
		t.inserisciCasella(tredici);
		Casella quattordici = new Casella(14, null, null);
		t.inserisciCasella(quattordici);
		Casella quindici = new Casella(15, null, null);
		t.inserisciCasella(quindici);
		Casella sedici = new Casella(16, null, null);
		t.inserisciCasella(sedici);
		Casella diciassette = new Casella(17, null, null);
		t.inserisciCasella(diciassette);
		Casella diciotto = new Casella(18, null, null);
		t.inserisciCasella(diciotto);
		Casella diciannove = new Casella(19, null, null);
		t.inserisciCasella(diciannove);
		Casella fine = new Casella(20, null, null);
		t.inserisciCasella(fine);
		
		
		t.setPrimo(uno);
		t.setUltimo(fine);
	}

}