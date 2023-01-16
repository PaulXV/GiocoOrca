import java.util.Objects;

public class Imprevisti {
	
	private String imprevisto;

	public Imprevisti(String imprevisto) {
		this.imprevisto = imprevisto;
	}
	
	public String getImprevisto() {return imprevisto;}
	
	public void setImprevisto(String imprevisto) {this.imprevisto = imprevisto;}


	@Override
	public String toString() {
		return "Imprevisto: " + imprevisto;
	}
	
	
}
