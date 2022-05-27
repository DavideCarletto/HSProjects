package punto;

import util.Tastiera;

public class Punto {
	
		static Tastiera t1 = new Tastiera();
		
		private int x;
		private int y;
	
		public Punto(int x, int y) {
		this.x = x;
		this.y = y;
		}

		double distanza (Punto p1) {
			return (Math.sqrt(Math.pow(this.x-p1.x,2)+Math.pow(this.y-p1.y, 2)));
		}
		
		public static void main (String[]args) {
			Punto p = new Punto(t1.LeggiNumeroIntero("Inserisci x:"),t1.LeggiNumeroIntero("Inserisci y: "));
			Punto p1 = new Punto(t1.LeggiNumeroIntero("Inserisci x2:"),t1.LeggiNumeroIntero("Inserisci y2: "));
			
			double distanza = p.distanza(p1);
			
			System.out.println("La distanza tra i due punti e': "+distanza);
		}
}
