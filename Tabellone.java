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
	
	public boolean vuota()	{return lunghezza == 0;}
	
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
            ultimo.setSuccessivo(c);
            c.setPrecedente(ultimo);
            ultimo = c;
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
	 * @param pos Numero della casella in cui deve essere spostata
	 * @param s Casella che deve essere spostata
	 * @param avanti Se la casella deve essere spostata in avanti o indietro
	 */
	public void sposta(int pos, Casella CasellaDaSpostare, boolean avanti)
	{	
		
		//manca un if in cui controllo che non sia in posizione primo o ultimo
		
		Casella precedente = CasellaDaSpostare.getPrecedente();
		Casella successivo = CasellaDaSpostare.getSuccessivo();
		precedente.setSuccessivo(successivo);
		
		if(avanti)
		{
			pos = CasellaDaSpostare.getPosizione()+pos-1;
			
			Casella nuovaPrecedente = casellaIn(pos-1);
			Casella nuovaSuccessiva = casellaIn(pos);
			CasellaDaSpostare.setPrecedente(nuovaPrecedente);
			CasellaDaSpostare.setSuccessivo(nuovaSuccessiva);
			nuovaPrecedente.setSuccessivo(CasellaDaSpostare);
			nuovaSuccessiva.setPrecedente(CasellaDaSpostare);
		}
		else
		{			
			pos = CasellaDaSpostare.getPosizione()-pos+1;
			
			Casella nuovaPrecedente = casellaIn(pos-1);
			Casella nuovaSuccessiva = casellaIn(pos);
			CasellaDaSpostare.setPrecedente(nuovaPrecedente);
			CasellaDaSpostare.setSuccessivo(nuovaSuccessiva);
			nuovaPrecedente.setSuccessivo(CasellaDaSpostare);
			nuovaSuccessiva.setPrecedente(CasellaDaSpostare);
		}

	}
}