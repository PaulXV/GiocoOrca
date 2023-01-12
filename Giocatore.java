class Giocatore {
    private String nome;
    private int punteggio;
    private char pedina;
    private String domandeFatte[];
    private int x;
    private int y;
 
    public Giocatore(String nome, char pedina, int x, int y) {
        this.nome = nome;
        this.pedina = pedina;
        this.x = x;
        this.y = y;
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
	
	  public int[] getPosizione() {
	        int[] posizione = {x, y};
	        return posizione;
	    }
    
}