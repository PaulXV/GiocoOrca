package Imprevisto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Imprevisto {
	
	private int punti;
	

	private Imprevisti[] imprevisti = new Imprevisti[10];	

	int cnt;

	public void leggiFile() throws IOException
	{
		FileReader imprevisti = new FileReader("C:\\Info\\Giuoco dell'Orca\\Imprevisti.txt");
		BufferedReader lettore = new BufferedReader(imprevisti);

		String riga = lettore.readLine();//lettura di una riga del file

		int i = 1;
		while(i <= 21) //fino a quando la riga nel file non è vuota, continua a leggere
		{
			riga = lettore.readLine();

			if((riga.charAt(0) >= 49 || riga.charAt(0) <= 53) 
					&&(riga.charAt(0) >= 13 || (riga.charAt(1) >= 49 && riga.charAt(1) <= 57)))
			{
				
				String imprevisto = lettore.readLine();
				
				aggiungiImprevisti(new Imprevisti(imprevisto));


				break; //una volta che crea l'imprevisto esce dal ciclo
			}

			riga = lettore.readLine(); //legge la prossima linea del file
			i++;
		}

		lettore=null;
		imprevisti.close();
	}
	
	public void aggiungiImprevisti(Imprevisti i)
	{
		imprevisti[cnt] = i;
		cnt++;
	}
	
	public void setPunti(int punti) {
	    this.punti += punti;
	}
	
	public String getImprevisto(int pos)  {return imprevisti[pos].toString();}
}
