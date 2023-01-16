public class MainGioco
{
	static Tabellone t;
	static Domandiere d;
	//Dado dado;
	//Imprevisti i;
	
	public static void main(String[] args)
	{
		//variabili generali:
		int tastoPremuto;
		
		//
		
		//inizializzazione globale 
		try {
			d.leggiFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//////////////////////////
		creaCaselle(20);
		//////////////////////////
		
		//

		System.out.println("Benvenuto nel GIUOCO DELL'ORCA");
		System.out.println("Premi 1 per inserire i giocatori");
		System.out.println("Premi 2 per il tutorial");
		System.out.println("Premi 3 per giocare - e' necessario creare i giocatori");
		System.out.println("Premi 0 per uscire dal gioco");
		
		do {
			tastoPremuto = Leggi.unInt();
			
			switch(tastoPremuto){
				case 1: inserimentoGiocatori(); break;
				case 2: tutorial(); break;
				case 3: gioco(); break;
				case 0: break;
				default: break;
			}
			
		}while(tastoPremuto == 0);
		
	}	
	
	static void creaCaselle(int numeroCaselle)
	{
		for(int i=0; i<numeroCaselle; i++)
		{
			Casella c = new Casella(i, null, null);
			t.inserisciCasella(c);
		}
	}
	
	static void inserimentoGiocatori()
	{
		//pulisce lo schermo
	}
	
	static void tutorial()
	{
		//pulisce lo schermo
	}
	
	static void gioco()
	{
		//pulisce lo schermo
	}
}