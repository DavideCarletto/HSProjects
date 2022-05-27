package liceocuneo.robot;

import lejos.nxt.Button;
import lejos.nxt.Motor;

public class TurtleRobot extends Robot {

	private Trasmissione t; 
	
	public TurtleRobot() {
		t = new Trasmissione();
		aggiungiComponente(t);
	}
	
	
	public void avanti() {
		/*for(int i=0; i<getElencoComponenti().length; i++) {
			if((getElencoComponenti()[i] != null) && (getElencoComponenti()[i] instanceof Trasmissione)) {
				Trasmissione t = (Trasmissione)getElencoComponenti()[i];
				t.avanti();
				break;
			}
		}*/
		t.avanti();
	}
	
	
	public void indietro() {
		
	}
	
	
	public void avanti(int numSec) {
		
	}
	
	
	public static void main(String[] args) {
		try {
			
			
			TurtleRobot r = new TurtleRobot();
			r.avanti();
			Button.waitForAnyPress();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
}
