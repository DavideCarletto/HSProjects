package liceocuneo.matematica;

public class Retta {
	private int m;
	private int q;
	
	public Retta (int m, int q) {
		this.m = m;
		this.q = q;
	}
	public boolean verificaPassaPerOrigine() {
		boolean ris;
		if (q == 0)
			ris = true;
		else 
			ris = false;
		
		return ris;
	}
	
	public boolean verificaAppartenenzaPunto(Punto p) {
		boolean ris;
		int ope = m*p.getX()+q;
		if (p.getY()==ope) 
			ris = true;
		else 
			ris = false;
		
		return ris;
	}
	
	public void visualizzaEquazioneEsplicita() {
		System.out.println("L'equazione esplicita della retta e' y= "+m+"x+"+q);
	}
}
