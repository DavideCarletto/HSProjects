package liceocuneo.libri;

import liceocuneo.util.Tastiera;

public class Laboratorio {
	
		static Tastiera t1 = new Tastiera();
		private String nome;
		Computer lab[] = new Computer[25];
		
		public Computer creaComputer() {
			Computer c1 = new Computer(t1.LeggiNumeroIntero("Inserisci il codice del pc: "),t1.LeggiNumeroFloat("Inserisci la frequenza del clock: "),t1.LeggiNumeroFloat("Inserisci i Gb di ram: "));
			return c1;
		}
		public void aggiungiComputer(Computer c, int i) {
			
				lab[i]=c;
		}
		
		public void rimuoviComputer(int opz) {
			for (int i=0; i<25; i++) {
			
				
				if ((opz<=25)&&(opz>=0)) {
					lab[opz] = null;
				}
			}
		}
		
		public static void main(String[]args) {
			Computer c1 = null;
			Laboratorio lab = new Laboratorio();
			
			for (int i=0; i<25; i++) {
			c1 = lab.creaComputer();
			lab.aggiungiComputer(c1, i);
			}
			int opz = t1.LeggiNumeroIntero("inserisci il valore dell'indice del computer che vuoi togliere: ");
			lab.rimuoviComputer(opz);
		}
}
