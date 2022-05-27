package campeggio;

import java.util.Scanner;

public class GestioneCampeggi {
	
	Scanner s = new Scanner(System.in);
	
	public Campeggio registraDati() {
		System.out.println("Inserici il nome del campeggio: ");
		String nome = s.next();
		System.out.println("Inserici l'indirizzo: ");
		int indirizzo = s.nextInt();
		System.out.println("Inserici la sua latitudine: ");
		float latitudine = s.nextFloat();
		System.out.println("Inserici la sua longitudine: ");
		float longitudine = s.nextFloat();
		
		Campeggio ca = new Campeggio (nome,indirizzo,latitudine,longitudine);
		return ca;
	}
	public void visualizzaDati(Campeggio cam) {
		if (cam != null) {
			System.out.println(""+cam.getNome()+"-"+cam.getIndirizzo()+"-"+cam.getLatitudine()+""+cam.getLongitudine());
		}
	}
	
	public void distanzaPunto(Campeggio cam) {
		System.out.println("Inserici la sua latitudine del punto : ");
		double latitudine = s.nextFloat();
		System.out.println("Inserici la sua longitudine del punto: ");
		double longitudine = s.nextFloat();
		Punto p = new Punto(latitudine,longitudine);
		double distanza = 0;
		double a = 90- p.getLatitudine();
		double b = 90- cam.getLatitudine();
		double o = p.getLongitudine()-cam.getLongitudine();
		double p1 = 0;
		distanza =   (Math.cos(a)*Math.cos(b)+Math.sin(a)*Math.sin(b) *  Math.cos(o))/Math.cos(p1);
		System.out.println("la distanza e "+distanza);
		
	}
	
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- Inserimento dati del campeggio: ");
		System.out.println("2- Visualizza dati campeggio");
		System.out.println("3- Calcolo distanza punto");
		System.out.println("4- Uscita");
		System.out.println("Scegli:");
		
		return s.nextInt();
	} 
	public static void main(String[]args) {
		GestioneCampeggi Gcamp = new GestioneCampeggi();
		int opz = 0;
		Campeggio camp = null;
		do {
			opz = Gcamp.menuUtente();
			switch(opz) {
			
			case 1 :
					camp = Gcamp.registraDati();
				break;
			case 2 :
					Gcamp.visualizzaDati(camp);
				break;
			case 3 :
				Gcamp.distanzaPunto(camp);
				break;
					
			case 4 :
				System.out.println("Arrivederci");
				break;
			}
		}while(opz!=4);
	}
}
