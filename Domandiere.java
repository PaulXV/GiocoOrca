import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Domandiere
{
	private Domanda[] domande = new Domanda[50];	
	private char[] risposte = new char[50];;
	int cnt;
	
	public void leggiFile() throws IOException
	{
		FileReader domande = new FileReader("G:\\scuola\\4IA\\Informatica\\Java\\Giuoco dell'Orca\\Domande.txt");
		BufferedReader lettore = new BufferedReader(domande);
		
		String riga = lettore.readLine();//lettura di una riga del file
		
		int i = 3;
		while(i <= 301) //fino a quando la riga nel file non è vuota, continua a leggere
		{
			riga = lettore.readLine();
					
			if((riga.charAt(0) >= 49 || riga.charAt(0) <= 53) 
				&&(riga.charAt(0) >= 13 || (riga.charAt(1) >= 49 && riga.charAt(1) <= 57)))
			{
				char risposta = riga.charAt(3);
				String domanda = lettore.readLine();
				//risposta = lettore.readLine();
				//r1 = risposta;
				String r1 = lettore.readLine();
				String r2 = lettore.readLine();
				String r3 = lettore.readLine();
				
				aggiungiDomanda(new Domanda(domanda, r1, r2, r3, risposta));
				
				//giocatore.setDomandaFatta(data.charAt(0), data.charAt(1));
				
				break; //una volta che crea la domanda esce dal ciclo
			}
			
			riga = lettore.readLine(); //legge la prossima linea del file
			i++;
		}
		
		lettore=null;
		domande.close();
	}
	
	public void aggiungiDomanda(Domanda d)
	{
		domande[cnt] = d;
		risposte[cnt] = d.getRispostaGiusta();
		cnt++;
	}
	
	public String getDomanda(int pos)  {return domande[pos].toString();}
	
	public char getRisposta(int pos)  {return risposte[pos];}
}