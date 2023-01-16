package GiuocoDellOrca;

import java.io.IOException;

public class mainProva {

	public static void main(String[] args) throws IOException {
		Domandiere domande = new Domandiere();
		domande.leggiFile();
		
		//pos sarà random
		domande.getDomanda(0);
		domande.getDomanda(1);
		
		System.out.println("Inserisci la lettera corretta ");
		char r1 = Leggi.unChar();
		domande.setRisposta(r1);
		
	}

}
