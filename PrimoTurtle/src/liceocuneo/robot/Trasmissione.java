package liceocuneo.robot;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Trasmissione extends Componente {
 
	private Motore motDx;
	private Motore motSx;
	DifferentialPilot pilot = new DifferentialPilot(2.5f,2.5f,Motor.A,Motor.B);
	

	public Trasmissione() {
		motDx = new Motore(PortaMotore.PORTA_A);
		motSx = new Motore(PortaMotore.PORTA_B);
	}
	
	
	public void avanti() {
		motDx.gira(VersoRotazione.ORARIA);
		motSx.gira(VersoRotazione.ORARIA);
	
	}
	public void avanti(int NumSec) {
	
		
	}
	public void indietro(int lenght) {
		pilot.travel(lenght);
	}
	
	
	public void gira(VersoGiro verso,int angolo) {
		switch(verso) {
		case DESTRA:
			pilot.rotate(angolo);
			break;
		
		case SINISTRA:
			pilot.rotate(angolo);
			break;
		}
	}
	
	public void stop() {
		pilot.stop();
	}
	
	public void ruota(VersoGiro verso, int angolo) {
		switch(verso) {
		case DESTRA:
			motDx.stop();
			motSx.ruota(angolo);
		case SINISTRA:
			motSx.stop();
			motDx.ruota(angolo);
			
		}


		
		
	}
}
