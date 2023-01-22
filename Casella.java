public class Casella
{
	protected int posizione;
	protected Casella successivo;
	protected Casella precedente;
	
	Casella(int pos, Casella precedente, Casella successivo)
	{
		posizione = pos;
		
		if(pos == 0)
			this.precedente = null;
		else
			this.precedente = precedente;
		
		this.successivo = successivo;
	}
	
	public int getPosizione()	{return posizione;}
	
	public Casella getSuccessivo()	{return successivo;}
	public Casella getPrecedente()	{return precedente;}
	
	public void setSuccessivo(Casella succ)	{successivo = succ;}
	public void setPrecedente(Casella prec)	{precedente = prec;}
}