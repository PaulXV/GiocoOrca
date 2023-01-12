class Giocatore {
    private String nome;
    private int punteggio;
    private char pedina;
    private String domandeFatte[];
    private Casella casGiocatore;
 
    public Giocatore(String nome, char pedina) {
        this.nome = nome;
        this.pedina = pedina;

    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public int getPunteggio() {
        return punteggio;
    }
 
    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
 
    public char getPedina() {
        return pedina;
    }
 
    public void setPedina(char pedina) {
        this.pedina = pedina;
    }

	public void setDomandeFatte(String[] domandeFatte) {
		this.domandeFatte = domandeFatte;
	}
	
	  public Casella getPosizione() {
	        return casGiocatore;
	    }
    
	  public Casella setPosizione(Casella casGiocatore) {
		  this.casGiocatore = casGiocatore;
	  }