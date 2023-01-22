public class Imprevisto
{
	private char numero;
	private String sanzione;
	
	Imprevisto(char numero, String sanzione)
	{
		this.numero = numero;
		this.sanzione = sanzione;
	}

	public char getNumero() {return numero;}
	public void setNumero(char numero) {this.numero = numero;}
	public String getSanzione() {return sanzione;}
	public void setSanzione(String sanzione) {this.sanzione = sanzione;}
}