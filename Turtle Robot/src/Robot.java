import lejos.nxt.Motor;

public class Robot{

	
	public void Muoviti(String cod) {
		
		if (cod.equals("Avanti")) {
			Motor.A.setSpeed(720);
			Motor.B.setSpeed(720);
			Motor.C.setSpeed(720);
			
			Motor.A.forward();
			
		}
		else if(cod.equals("Indietro")) {
			Motor.A.setSpeed(720);
			Motor.B.setSpeed(720);
			Motor.C.setSpeed(720);
			
			Motor.A.backward();
		}
	
	}
	public void Ruota () {
		Motor.A.rotate(360);
	}
	public void Ferma () {
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
	}
	public static void main (String args[]) {
		
	}
}
