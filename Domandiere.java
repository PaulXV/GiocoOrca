package GiuocoDellOrca;

public class Domandiere {
	private Domanda[] domandiere;
	private char[] risposte;
	
	private int i = 0;
	domandiere[i] = new Domanda("Qual è la capitale dell'Italia?\n", "Milano", "Udine", "Roma", 'c');
	i++;
	domandiere[i] = new Domanda("Qual è lo stato con più persone al mondo?\n", "Cina", "India", "Stati Uniti", 'a');
	i++;
	
	//prende la domanda dall'array casualmente e la mostra a schermo
	public Domanda getDomanda() {
		return domandiere[2];
	}
	
	/*public void setDomanda() {
		Domanda d = new Domanda(String domanda, String primaScelta, String secondaScelta, String terzaScelta, 
								String rispostaGiusta);
	}*/
	
	
	
	
}

/*
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
		
		int i = 0;
		int domanda = (int)(Math.random()*50);
		while(i <= domanda) //fino a quando la riga nel file non è vuta, continua a leggere
		{
			System.out.println(riga);
			riga = lettore.readLine();
			
			
			
			//il valore da controllare (49 e 50) dovrà essere variabile che cambia in base al numero estratto a random
			if(riga.charAt(0) == 49 && riga.charAt(1) == 50) {
				System.out.println(riga);
				riga = lettore.readLine();
				System.out.println(riga);
				
				//giocatore.setDomandaFatta(data.charAt(0), data.charAt(1));
				
				break; //una volta che stampa esce dal ciclo
			}
			
			riga = lettore.readLine(); //legge la prossima linea del file
			i++;
		}
		
		//lettore=null;
		domande.close();
	}
}*/