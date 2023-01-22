public class Tabellone
{
	protected Casella primo;
	protected Casella ultimo;
	protected int lunghezza;

	public boolean vuota()	{return lunghezza == 0;}
	public void setLunghezza(int lunghezza) {this.lunghezza = lunghezza;}
	public int getLunghezza() {return lunghezza;}
	public Casella getUltimo() {return ultimo;}
	public Casella getPrimo() {return primo;}
	public void setUltimo(Casella c) {this.ultimo = c;}
	public void setPrimo(Casella c) {this.primo = c;}
	
	public void inserisciPrimo(Casella c){
        primo = c;
        if (vuota())
            ultimo = primo;
        lunghezza++;
    }
	
	public void inserisciCasella(Casella c)
	{
		if (vuota())
            inserisciPrimo(c);
        else {
            ultimo.setSuccessivo(c);
            c.setPrecedente(ultimo);
            ultimo = c;
        }
		
		lunghezza++;
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
		if(CasellaDaSpostare == primo || CasellaDaSpostare == ultimo
				||  (CasellaDaSpostare.getPosizione()+pos >= ultimo.getPosizione())
				||  (CasellaDaSpostare.getPosizione()-pos <= primo.getPosizione()))
		{
			Casella precedente = CasellaDaSpostare.getPrecedente();
			Casella successivo = CasellaDaSpostare.getSuccessivo();
			precedente.setSuccessivo(successivo);
			
			if(avanti)	{pos = CasellaDaSpostare.getPosizione()+pos-1;}
			else		{pos = CasellaDaSpostare.getPosizione()-pos-1;}
			
			Casella nuovaPrecedente = casellaIn(pos-1);
			Casella nuovaSuccessiva = casellaIn(pos);
			CasellaDaSpostare.setPrecedente(nuovaPrecedente);
			CasellaDaSpostare.setSuccessivo(nuovaSuccessiva);
			nuovaPrecedente.setSuccessivo(CasellaDaSpostare);
			nuovaSuccessiva.setPrecedente(CasellaDaSpostare);
		}
	}
}