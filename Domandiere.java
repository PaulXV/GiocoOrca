package GiuocoDellOrca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Domandiere
{
	private Domanda[] domande = new Domanda[50];	
	private char[] risposte = new char[50];;
	private int cnt = 0;
	
	public void leggiFile() throws IOException
	{
		FileReader dom = new FileReader("G:\\scuola\\4IA\\Informatica\\Java\\Eclipse\\src\\GiuocoDellOrca\\Domande.txt");
		BufferedReader lettore = new BufferedReader(dom);
		
		String riga = lettore.readLine();//lettura della prima riga del file
		
		
		int i = 1;
		while(i <= 50) //fino a quando la riga nel file non è vuota, continua a leggere
		{
			riga = lettore.readLine();
			riga = lettore.readLine();
					
			if((riga.charAt(0) >= 49 || riga.charAt(0) <= 53) 
				&&(riga.charAt(1) == 32 || (riga.charAt(1) >= 48 && riga.charAt(1) <= 57)))
			{
				char rispostaGiusta = riga.charAt(3);
				String domanda = lettore.readLine();
				//risposta = lettore.readLine();
				//r1 = risposta;
				String r1 = lettore.readLine();
				String r2 = lettore.readLine();
				String r3 = lettore.readLine();
				
				aggiungiDomanda(new Domanda(domanda, r1, r2, r3, rispostaGiusta));
				//domande[i] = new Domanda(domanda, r1, r2, r3, rispostaGiusta);
				//System.out.println(domande[i]);
				
				//giocatore.setDomandaFatta(data.charAt(0), data.charAt(1));
			}
			
			//riga = lettore.readLine(); //legge la prossima linea del file
			i++;
		}
		
		lettore=null;
		dom.close();
	}
	
	public void aggiungiDomanda(Domanda d)
	{
		domande[cnt] = d;
		//System.out.println(d);
		risposte[cnt] = d.getRispostaGiusta();
		cnt++;
	}
	
	public String getDomanda(int pos)  {return domande[pos].toString();}
	
	public char getRisposta(int pos)  {return risposte[pos];}
	
	private int k = 0;
	public boolean setRisposta(char r)  {
		k++;
		return domande[k].corretta(r);
	}
}