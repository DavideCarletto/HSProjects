package liceocuneo.robot;

import lejos.util.Delay;

public class Trasmissione extends Componente {
 
	private Motore motDx;
	private Motore motSx;

	public Trasmissione() {
		motDx = new Motore(PortaMotore.PORTA_A);
		motSx = new Motore(PortaMotore.PORTA_B);
	}
	
	
	public void avanti() {
		motDx.gira(VersoRotazione.ORARIA);
		motSx.gira(VersoRotazione.ORARIA);
	
	}
	
	public void indietro() {
		motDx.gira(VersoRotazione.ANTIORARIA);
		motSx.gira(VersoRotazione.ANTIORARIA);
	}
	public void stop() {
		motoDx.stop();
	 
	}
	public void gira() {
		motoSx.ruota();
	}
}
