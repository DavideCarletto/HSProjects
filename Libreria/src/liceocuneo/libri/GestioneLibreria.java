package liceocuneo.libri;

import liceocuneo.util.Tastiera;

public class GestioneLibreria {
	
		Libro magazzino[] = new Libro[100];
		Tastiera t1 = new Tastiera();
		
		public Libro creaLibro() {
			Libro l1 = new Libro(t1.leggiNumero("Inserisci codice Isbn:"), t1.leggiNumero("Inserisci il titolo:"),t1.LeggiNumeroFloat("Inserisci il prezzo:"),t1.LeggiNumeroIntero("Quantita?"));
			return l1;
		}
		public int aggiungiLibro (Libro l1) {
			
			int quantita=0;
			int conta =0;
			
			do {
				int i=0;
			if ((l1.getCodice().equals(magazzino[i].getCodice()))&&(l1.getTitolo().equals(magazzino[i].getTitolo()))&&(l1.getPrezzo()==magazzino[i].getPrezzo())) {
				quantita = l1.getQta()+magazzino[i].getQta();
				conta++;
				}
			if(magazzino[i]==null) {
				magazzino[i]=l1;
				conta++;
			}
			i++;
			}while(conta==0);	
			
			return quantita;
		}
		public void elencoLibri() {
			
			System.out.println("Ecco i libri presenti nel magazzino: ");
			for (int i=0; magazzino[i]!=null; i++) {
				
				System.out.println(magazzino[i].getTitolo()+" ,");
			}
		}
		
		public int venditaLibro(Libro l1) {
			int quantita=0;
			int conta =0;
			
			do {
				int i=0;
			if ((l1.getCodice().equals(magazzino[i].getCodice()))&&(l1.getTitolo().equals(magazzino[i].getTitolo()))&&(l1.getPrezzo()==magazzino[i].getPrezzo())) {
				quantita = magazzino[i].getQta()-l1.getQta();
				conta++;
				}
			}while(conta==0);	
			
			return quantita;
		}
		public void quantitaTot(int qta) {
			System.out.println("n Libri: "+qta);
		}
		public float ricavoVendita(Libro l1,int qta) {
			float ricavo=0;
			int conta=0;
			do {
				int i=0;
			if ((l1.getCodice().equals(magazzino[i].getCodice()))&&(l1.getTitolo().equals(magazzino[i].getTitolo()))&&(l1.getPrezzo()==magazzino[i].getPrezzo())) {
				ricavo = (magazzino[i].getQta()-l1.getQta())*l1.getPrezzo();
				conta++;
				}
			}while(conta==0);	
			return ricavo;	
		}
		public int menuUtente() {
			
			System.out.println("MENU UTENTE");
			System.out.println("1- Aggiungi libro a magazzino");
			System.out.println("2- Elenco libri magazzino");
			System.out.println("3- Vendita libro");
			System.out.println("4- Calcola quantita totale a magazzino");
			System.out.println("5- Calcola ricavo di vendita");
			System.out.println("6- Uscita");
			
			return t1.LeggiNumeroIntero("Inserisci l'opzione:");
		}
		
		public static void main (String[]args) {
			GestioneLibreria Glibre = new GestioneLibreria();
			Libro l1=null;
			
			int opz=0;
			
			do {
				
				opz = Glibre.menuUtente();
				int qta = 0;
				switch (opz) {
					
					case 1: l1=Glibre.creaLibro();
							qta=Glibre.aggiungiLibro(l1);
							break;
							
					case 2: Glibre.elencoLibri();
							break;
							
							
					case 3: System.out.println("Quale libro si desidera vendere?");
							l1=Glibre.creaLibro();
							qta = Glibre.venditaLibro(l1);
							break;
							
					case 4: Glibre.quantitaTot(qta);
							break;
							
					case 5: System.out.println("il ricavo della vendita e'"+Glibre.ricavoVendita(l1,qta));
							break;
					
					case 6: System.out.println("Arrivederci!");
						break;
				}
			}while(opz<6);
		
		}
}
