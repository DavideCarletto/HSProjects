package liceocuneo.robot;

public abstract class Robot {

	private static final int NUM_MAX_COMP = 1000;
	private Componente[] elencoComponenti;
	private int index;
	
	
	public Robot() {
		elencoComponenti = new Componente[NUM_MAX_COMP];
		index = 0;
	}
	
	
	public void aggiungiComponente(Componente c) {
		if(c != null) {
			elencoComponenti[index++] = c;
		}
	}


	public Componente[] getElencoComponenti() {
		return elencoComponenti;
	}
	
	
}
