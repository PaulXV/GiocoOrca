class Giocatore
{
	Tabellone t = new Tabellone();
    private String nome;
    private int punteggio;
    private char pedina;
    private String domandeFatte[] = new String[50];
    private Casella casGiocatore;
    int cnt=0;
 
    public Giocatore(String nome, char pedina, Tabellone t) {
        this.nome = nome;
        this.pedina = pedina;
        this.t = t;
    }
 
    public String getNome() {return nome;}
 
    public void setNome(String nome) {this.nome = nome;}
 
    public int getPunteggio() {return punteggio;}
 
    public void setPunteggio(int punteggio) {this.punteggio += punteggio;}
 
    public char getPedina() {return pedina;}
 
    public void setPedina(char pedina) {this.pedina = pedina;}

	public void setDomandeFatte(String d) {domandeFatte[cnt] = d; cnt++;}
	
	public Casella getPosizione() {return casGiocatore;}
    
	public int getPosInt()  {return casGiocatore.getPosizione();}
	
	public void setPosizione(int numCasellaNuova) 
	{
		if(casGiocatore == null)
			casGiocatore = t.casellaIn(0);
		else
			casGiocatore = t.casellaIn(casGiocatore.getPosizione()+numCasellaNuova);
	}
}