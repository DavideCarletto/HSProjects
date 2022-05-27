package liceocuneo.NXT;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class TrazioneNXT {

	private Motore motA;
	private Motore motB;
	DifferentialPilot pilot = new DifferentialPilot(2.5f,4.5f,Motor.A,Motor.B);
	
	
	public void attendiEAvanza(long tempoMs) {
		try {
			Thread.sleep(tempoMs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pilot.forward();
	}
	public void impostaVelocita(int spazioCentimetri, int tempoSec){
		
		float velocit‡ = 0;
		float spazioMetri = (float)spazioCentimetri/100;
		velocit‡ = spazioMetri/(float)tempoSec;
		float velocit‡Radianti = velocit‡/2.5f; 
		
		Motor.A.setSpeed(velocit‡Radianti);
		Motor.B.setSpeed(velocit‡Radianti);
		
	}
}
