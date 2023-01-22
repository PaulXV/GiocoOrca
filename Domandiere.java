import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Domandiere
{
	private Domanda[] domande = new Domanda[50];	
	private char[] risposte = new char[50];
	private int cntDomande = 0;
	private int cntRisposte = 0;
	
	public void leggiFile() throws IOException
	{
		FileReader domande = new FileReader("C:\\Users\\paolo\\Desktop\\Scuola\\Informatica\\Eclipse\\GiuocoOrca\\src\\Domande.txt");
		BufferedReader lettore = new BufferedReader(domande);
		String riga;
		char risposta = ' ';
		
		while(lettore != null) //fino a quando la riga nel file non è vuota, continua a leggere
		{
			riga = lettore.readLine();
			
			if(riga == null)
				break;
			
			if(riga.equals("-")) 
			{
				riga = lettore.readLine();
				risposta = riga.charAt(2);
				aggiungiRisposta(risposta);
				
				String domanda = lettore.readLine();
				String r1 = lettore.readLine();
				String r2 = lettore.readLine();
				String r3 = lettore.readLine();
				
				Domanda d = new Domanda(domanda,r1,r2,r3,risposta);
				aggiungiDomanda(d);
			}

		}
		
		lettore.close();;
		domande.close();
	}
	
	public void aggiungiDomanda(Domanda d)
	{
		domande[cntDomande] = d;
		cntDomande += 1;
	}
	
	void aggiungiRisposta(char r)
	{
		risposte[cntRisposte] = r;
		cntRisposte +=1;
	}
	
	public String getDomanda(int pos)  {return domande[pos].toString();}
	
	public char getRisposta(int pos)  {return risposte[pos];}
}