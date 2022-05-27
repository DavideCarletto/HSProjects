package centralinaMeteorologica;

import java.util.Scanner;

public class Gestioneeventi {
	
	private static final int NUM_MAX_EV = 100;
	private Evento elencoEv[] = null;
	static Scanner s = new Scanner(System.in);
	private int index = 0; 
	
	public Gestioneeventi() {
		elencoEv = new Evento[NUM_MAX_EV];
	}
	public Evento creaEvento() {
		System.out.println("Inserisci un valore decimale: ");
		float num = s.nextFloat();
		System.out.println("Inserisci la tipologia (1-VENTO, 2-UMIDITA, 3-TEMPERATURA, 4-RADIZIONE_UV): ");
		int scelta = s.nextInt();
		TipologiaEvento tipo = null;
		boolean valore=false;
		
		while(valore==false) {
			switch(scelta) {
			
			case 1:tipo = TipologiaEvento.VENTO;
					valore = true;
					break;
			case 2:tipo = TipologiaEvento.UMIDITA;
					valore = true;
					break;
			case 3:tipo = TipologiaEvento.TEMPERATURA;
					valore = true;
					break;
			case 4:tipo = TipologiaEvento.RADIZIONE_UV;
					valore = true;
					break;
			
			}
		}
		int numProg = elencoEv[index-1].getNumeroProgressivo()+1;
		Evento ev = new Evento(num,tipo,numProg);
		return ev;
	}
	public void aggiungiEvento (Evento e) {
		elencoEv[index++] = e;
	}
	
	public void visualizzaEventi() {
		for (int i=0; i<index; i++) {
			System.out.println(""+(i+1)+"-"+elencoEv[i].getTipologia()+"-"+elencoEv[i].getNumDecimale()+"-"+elencoEv[i].getNumeroProgressivo());
		}
	}
	public boolean esisteEvento(int numeroProg) {
		boolean valore = true;
		for (int i=0; i<index; i++) {
		if(elencoEv[i].getNumeroProgressivo()==numeroProg) {
			valore = true;
			break;
		}
		
		else valore = false;
		}
		return valore;
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- crea un evento");
		System.out.println("2- visualizza tutti gli eventi");
		System.out.println("3- esiste evento?");
		System.out.println("4- uscita");
		System.out.println("Scegli:");
		
		return s.nextInt();
	}

	public static void main (String[]args) {
		Gestioneeventi gEv = new Gestioneeventi();
		int opz = 0;
		Evento e = null;
		
		do {
			opz = gEv.menuUtente();
			switch(opz) {
			case 1 :
					 e = gEv.creaEvento();
					 gEv.aggiungiEvento(e);
				break;
			
			case 2 :
					gEv.visualizzaEventi();
				break;
			
			case 3 :
				System.out.println("Inserisci un numero intero: ");
				int numeroProg = s.nextInt();
				if (gEv.esisteEvento(numeroProg)==true)
					System.out.println("esiste un evento con questo numero.");
				else 
					System.out.println("non esiste un evento con questo numero.");
				break;
			
			case 4 :
				System.out.println("Arrivederci!");
				break;
			
			
			}
		}while(opz!=4);
	}
}
