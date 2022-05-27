package liceocuneo.robot;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;

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
		t.avanti();
		Delay.msDelay(numSec*1000);
		t.stop();
	}
	public void giraDx() {
		t.gira();
	}
	
	public static void main(String[] args) {
		int numGiri = 4;
		try {
			TurtleRobot r = new TurtleRobot();
			for (int i = 0; i< numGiri; i++) {
				r.avanti(2);
				r.giraDx();
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
}
