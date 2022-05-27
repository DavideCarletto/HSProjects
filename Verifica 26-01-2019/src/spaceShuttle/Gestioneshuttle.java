package spaceShuttle;

import java.util.Scanner;

public class Gestioneshuttle {
	private static final float acc = 3*9.81f;
	private static final float vmax = 28000/3.6f;
	
	public float restituisciVelocita(float tempo) {
		float velocita= acc*tempo;
		
		if(velocita>vmax)
			velocita = vmax;
		
		return velocita;
	}
	
	
	public static void main(String[]args) {
		Gestioneshuttle g = new Gestioneshuttle();
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci il tempo:");
		float tempo = s.nextFloat();
		System.out.println("lo space shuttle dopo "+tempo+" secondi ha una velocita di "+g.restituisciVelocita(tempo)+" m/s");
		
	}
}
