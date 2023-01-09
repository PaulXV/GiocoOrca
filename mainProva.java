package GiuocoDellOrca;

public class mainProva {

	public static void main(String[] args) {
		Domanda d1 = new Domanda("Qual è la capitale dell'Italia?\n", "Milano", "Udine", "Roma", 'c');
		Domanda d2 = new Domanda("Qual è lo stato con più persone al mondo?\n", "Cina", "India", "Stati Uniti", 'a');
		
		System.out.println(d1);
		int r1 = Leggi.unChar();
	}

}
