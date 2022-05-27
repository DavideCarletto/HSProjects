package liceocuneo.robot;


import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Motore extends Componente {

	private PortaMotore porta;
	
	public Motore(PortaMotore p) {
		porta = p;
	}
	
	
	public void gira(VersoRotazione vr) {
		switch(porta) {
		case PORTA_A: {
			if(vr == VersoRotazione.ORARIA) {
				Motor.A.forward();
			}
			else {
				Motor.A.backward();
			}
			break;
		}
		case PORTA_B: {
			if(vr == VersoRotazione.ORARIA) {
				Motor.B.forward();
			}
			else {
				Motor.B.backward();
			}
			break;
		}
		case PORTA_C: {
			if(vr == VersoRotazione.ORARIA) {
				Motor.C.forward();
			}
			else {
				Motor.C.backward();
			}
			break;
		}
		}
	}
	public void stop() {
		switch(porta) {
		case PORTA_A: {
			Motor.A.stop();
			break;
		}
		case PORTA_B: {
			Motor.B.stop();
			break;
		}
		case PORTA_C: {
			Motor.C.stop();
			break;
		}
		}
		
	}
	public void ruota(int angolo) {
			switch(porta) {
				case PORTA_A: {
					Motor.A.rotate(angolo);
					break;
				}
				case PORTA_B: {
					Motor.A.rotate(angolo);
					break;
				}
				case PORTA_C: {
					Motor.A.rotate(angolo);
					break;
				}
			}
		}
	}

