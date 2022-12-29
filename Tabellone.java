public class Tabellone
{
	private Casella primo;
	private Casella ultimo;
	private int lunghezza;
	
	Tabellone()
	{
		primo = null;
		ultimo = null;
		lunghezza = 0;
	}
	
	public boolean vuota()
	{
		return lunghezza == 0;
	}
	
	public void inserisciPrimo(int elemento){
        primo = new Casella(elemento,primo, null);
        if (vuota())
            ultimo = primo;
        lunghezza++;
    }
	
	public void inserisciCasella(Casella c)
	{
		if (vuota())
            inserisciPrimo(c.getPosizione());
        else {
            ultimo.setSuccessivo(new Casella(c.getPosizione(),ultimo.getPrecedente(), null));
            ultimo = ultimo.getSuccessivo();
            lunghezza++;
        }
		
		lunghezza++;
	}
	
	public String toString()
	{		
		Casella cas = primo;
		String elementi = "";
		for(int i=0; i<lunghezza; i++)
		{
			elementi += "" + cas.getPosizione() + " \n";
			cas = cas.getSuccessivo();
			if(cas == null)
				break;
		}
		
		return elementi;
	}
	
	public Casella casellaIn(int posizione) {
        Casella c = primo;
        for(int salto=0; salto<posizione; salto++) {
            c = c.getSuccessivo();
        }
        return c;
    }
	
	/**
	 * Funzione per spostare la Casella s di num posizioni
	 * @param pos Numero di caselle che la casella s deve essere spostata
	 * @param s Casella che deve essere spostata
	 * @param avanti Se la casella deve essere spostata in avanti o indietro
	 */
	public void sposta(int pos, int CasellaDaSpostare, boolean avanti)
	{
		if(avanti) {
			Casella precedente = casellaIn(pos);
			Casella seguente = precedente.getSuccessivo();
			Casella nuova = new Casella(CasellaDaSpostare, precedente, seguente);
		    precedente.setSuccessivo(nuova);
		    nuova.setSuccessivo(seguente);
		}
		
		//elimina la Casella che è stata spostata
		Casella precedente = casellaIn(CasellaDaSpostare-1);
		Casella daEliminare = precedente.getSuccessivo();
        precedente.setSuccessivo(daEliminare.getSuccessivo());

	}
}