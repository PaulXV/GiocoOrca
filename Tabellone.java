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
	
	public void inserisciCasella(Casella c)
	{
		primo = c;
		if (vuota())
			ultimo = primo;
		lunghezza++;
	}
	
	public String toString()
	{		
		Casella cas = primo;
		String elementi = "";
		for(int i=0; i<lunghezza; i++)
		{
			elementi += "" + cas.getPosizione() + " ";
			cas = cas.getSuccessivo();
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
	 * Funzione per spostare la casella s di num posizioni
	 * @param num Numero di caselle che la casella s deve essere spostata
	 * @param s Casella che deve essere spostata
	 */
	public void sposta(int num, Casella s)
	{
		Casella nuovoNodo = new Casella(s.getPosizione());
		Casella precedente = casellaIn(num-1);
		Casella seguente = precedente.getSuccessivo();
        precedente.setSuccessivo(nuovoNodo);
        nuovoNodo.setSuccessivo(seguente);
        lunghezza++;
	}
}
