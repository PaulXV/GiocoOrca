
public class usoCasella {

	public static void main(String[] args)
	{
		Casella uno = new Casella(1);
		Casella due = new Casella(2);
		Casella tre = new Casella(3);
		
		Tabellone gioco = new Tabellone();
		gioco.inserisciCasella(uno);
		gioco.inserisciCasella(due);
		gioco.inserisciCasella(tre);
		gioco.sposta(3, uno);
		System.out.println(gioco.toString());
		
	}

}
