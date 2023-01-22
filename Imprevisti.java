import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Imprevisti {
	
	protected Imprevisto[] imprevisti = new Imprevisto[5];	
	protected int cnt;
	
	public void leggiFile() throws IOException
	{
		FileReader imprevisti = new FileReader("C:\\Users\\paolo\\Desktop\\Scuola\\Informatica\\Eclipse\\GiuocoOrca\\src\\Imprevisti");
		BufferedReader lettore = new BufferedReader(imprevisti);
		String riga;
		char numero = ' ';
		String sanzione = "";
		
		while(lettore != null) //fino a quando la riga nel file non è vuota, continua a leggere
		{
			riga = lettore.readLine();
			
			if(riga == null)
				break;
			
			if(riga.equals("-")) 
			{
				riga = lettore.readLine();
				numero = riga.charAt(0);
			
				sanzione = lettore.readLine();
				
				Imprevisto i = new Imprevisto(numero, sanzione);
				aggiungiImprevisto(i);
			}

		}
		
		lettore.close();
		imprevisti.close();
	}
	
	public void aggiungiImprevisto(Imprevisto i)
	{
		imprevisti[cnt] = i;
		cnt++;
	}
	
	public void getImprevisto(int pos, Giocatore g)
	{
		if(imprevisti[pos].getNumero() <= '2')
		{
			System.out.println("Tieni d'occhio i tuoi punti!");
			
			char numeroPunti = imprevisti[pos].getSanzione().charAt(1);
			
			if(imprevisti[pos].getSanzione().charAt(0) == '-')
				g.setPunteggio(0-numeroPunti);
			else
				g.setPunteggio(numeroPunti);

		}
		else if(imprevisti[pos].getNumero() >= '3')
		{
			System.out.println("Verrai spostato su un'altra casella - occhio!");
			
			char numeroCaselle = imprevisti[pos].getSanzione().charAt(1);
			
			if(imprevisti[pos].getSanzione().charAt(0) == '-')
				g.setPosizione(0-numeroCaselle);
			else
				g.setPosizione(numeroCaselle);
			
			if(imprevisti[pos].getSanzione().charAt(0) == '#')
			{
				g.setPosizione((g.getPosInt())*(-1)+2);
			}
		}
	}
}