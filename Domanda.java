package GiuocoDellOrca;

import java.util.Objects;

public class Domanda {
	private String domanda;
	private String primaScelta;
	private String secondaScelta;
	private String terzaScelta;
	private char rispostaGiusta;
	
	public Domanda(String domanda, String primaScelta, String secondaScelta, String terzaScelta, char rispostaGiusta) {
		this.domanda = domanda;
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
		this.terzaScelta = terzaScelta;
		this.rispostaGiusta = rispostaGiusta;
	}

	public String getDomanda() {return domanda;}

	public void setDomanda(String domanda) {this.domanda = domanda;}

	public String getPrimaScelta() {return primaScelta;}

	public void setPrimaScelta(String primaScelta) {this.primaScelta = primaScelta;}

	public String getSecondaScelta() {return secondaScelta;}

	public void setSecondaScelta(String secondaScelta) {this.secondaScelta = secondaScelta;}

	public String getTerzaScelta() {return terzaScelta;}

	public void setTerzaScelta(String terzaScelta) {this.terzaScelta = terzaScelta;}

	public char getRispostaGiusta() {return rispostaGiusta;}

	public void setRispostaGiusta(char rispostaGiusta) {this.rispostaGiusta = rispostaGiusta;}
	
	
	//prende la risposta data in input dal giocatore e verifica che sia corretta
	public boolean corretta(char risposta) {
		if(risposta == getRispostaGiusta()) {
			System.out.println("corretto\n");
			return true;
		}
		else {
			System.out.println("sbagliato\n");
			return false;
		}
			
	}
	
	public String toString() {
		return domanda + "\na)" + primaScelta + "\nb)" + secondaScelta
				+ "\nc)" + terzaScelta;
	}
}