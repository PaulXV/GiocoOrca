import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DomandiereProva
{
	public static void main(String[] args) throws IOException
	{
		FileReader dom = new FileReader("domande.txt");
		BufferedReader lettore = new BufferedReader(dom);
		
		String data = lettore.readLine();//lettura della prima linea del file
		
		while(data != null) //fino a quando non trova più niente nel file domande.txt
		{
			//il valore da controllare (49 e 50) dovrà essere variabile che cambia in base al numero estratto a random
			if(data.charAt(0) == 49 && data.charAt(1) == 50) {
				System.out.println(data);
				data = lettore.readLine();
				System.out.println(data);
				
				//giocatore.setDomandaFatta(data.charAt(0), data.charAt(1));
				
				break; //una volta che stampa esce dal ciclo
			}
			
			data = lettore.readLine(); //legge la prossima linea del file
		}
		
		lettore=null;
		dom.close();
	}
}