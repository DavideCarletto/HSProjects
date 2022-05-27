package liceocuneo.matematica;

public class Retta {

	private int m;
	private int q;
	
	
		
	public Retta(int m, int q) {
		this.m = m;
		this.q = q;
	}
	
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public boolean verificaPassaPerOrigine() {
		
		return false;
	}
	
	public boolean verificaAppartenenzaPunto(Punto p) {
		return false;
	}
	
	public void visualizzaEquazioneEsplicita() {
		
	}
}
