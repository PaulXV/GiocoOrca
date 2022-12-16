public class Casella
{
	private int posizione;
	private Casella successivo;
	private Casella precedente;
	
	Casella(int pos)
	{
		posizione = pos;
		if(pos == 0)
			precedente = null;
	}
	
	public int getPosizione()	{return posizione;}
	
	public Casella getSuccessivo()	{return successivo;}
	public Casella getPrecedente()	{return precedente;}
	
	public void setSuccessivo(Casella succ)	{successivo = succ;}
	public void setPrecedente(Casella prec)	{precedente = prec;}
}
