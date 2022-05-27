package matematica;

import util.Tastiera;

public class Quadrato {
	private int lato;
 
	public Quadrato(int lato) {
		super();
		this.lato = lato;
	}
	
	public int getLato() {
		return lato;
	}
	
	public int  calcolaPerimetro() {
		return lato*4;
	}
	
	
	public int calcolaArea() {
		return lato*lato;
	}
	
	public static void main(String [] args) {
	
		Tastiera t1 = new Tastiera();
		Quadrato q1 = new Quadrato(t1.leggiNumeroIntero("Inserisci il valore del lato: "));
		
		System.out.println("il lato vale "+q1.getLato());
	}


}
