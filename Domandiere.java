package GiuocoDellOrca;

/*public class Domandiere {
	private char[] risposte;
	
	public void getDomanda() {
		//prende la domanda dal file di testo e la mostra a schermo
	}
	
	public boolean corretta(char risposta) {
		//prende la risposta data in input dal giocatore e verifica che sia corretta
		
		return false;
	}
	
	
}*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Domandiere
{
	public static void main(String[] args) throws IOException
	{
		FileReader domande = new FileReader("G:\\scuola\\4IA\\Informatica\\Java\\Giuoco dell'Orca\\Domande.txt");
		BufferedReader lettore = new BufferedReader(domande);
		
		//System.out.println(lettore.readLine()); non funziona bene
		String riga = lettore.readLine();//lettura di una riga del file
		
		while(riga != null) //fino a quando la riga nel file non è vuta, continua a leggere
		{
			System.out.println(riga);
			riga = lettore.readLine();
			
			
			/*il valore da controllare (49 e 50) dovrà essere variabile che cambia in base al numero estratto a random
			if(data.charAt(0) == 49 && data.charAt(1) == 50) {
				System.out.println(data);
				data = lettore.readLine();
				System.out.println(data);
				
				//giocatore.setDomandaFatta(data.charAt(0), data.charAt(1));
				
				break; //una volta che stampa esce dal ciclo
			}
			
			data = lettore.readLine(); //legge la prossima linea del file*/
		}
		
		//lettore=null;
		domande.close();
	}
}