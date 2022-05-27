package liceocuneo.robot;

import lejos.util.Delay;

public class TurtleRobot extends Robot {

	private Trasmissione t; 
	
	public TurtleRobot() {
		t = new Trasmissione();
		aggiungiComponente(t);
	}
	
	
	public void avanti() {
		for(int i=0; i<getElencoComponenti().length; i++) {
			if((getElencoComponenti()[i] != null) && (getElencoComponenti()[i] instanceof Trasmissione)) {
				Trasmissione t = (Trasmissione)getElencoComponenti()[i];
				t.avanti();
				break;
			}
		}

	}
	
	
	public void indietro() {
		
	}
	
	
	public void avanti(int numSec) {
		t.avanti();
		try {
			Thread.sleep(numSec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
	
	}
}
