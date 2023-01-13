public class usoCasella {

	public static void main(String[] args)
	{
		Casella uno = new Casella(1, null, null);
		Casella due = new Casella(2, uno, null);
		Casella tre = new Casella(3, due, null);
		Casella quattro = new Casella(4, tre, null);
		Casella cinque = new Casella(5, quattro, null);
		
		
		Tabellone gioco = new Tabellone();
		gioco.inserisciCasella(uno);
		gioco.inserisciCasella(due);
		gioco.inserisciCasella(tre);
		gioco.inserisciCasella(quattro);
		gioco.inserisciCasella(cinque);
		
		
		System.out.println(gioco.toString());
		gioco.sposta(1, tre, true);
		System.out.println(gioco.toString());	
	}
}