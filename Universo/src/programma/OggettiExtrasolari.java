package programma;

import java.util.Scanner;

public class OggettiExtrasolari {

	private static final int NUM_MAX_OGG = 100;
	private OggettoExtrasolare elencoOggetti[];
	private int index;
	static Scanner s = new Scanner(System.in);
	
	public  OggettiExtrasolari() {
		elencoOggetti = new OggettoExtrasolare[NUM_MAX_OGG];
		index = 0;
	}
	
	public OggettoExtrasolare inserisciOggetto(){
		System.out.println("Inserisci il nome dell'oggetto: ");
		String nome = s.next();
		
		float magnitudine =0;
		boolean isValid = true;
		float distanzaTerra =0;
		
		do {
			System.out.println("Inserisci la sua magintudine (valore che va da -1 a 12)");
			String magnitudineStr = s.next();
			
			try{
				magnitudine = Float.parseFloat(magnitudineStr);
				if(magnitudine<-1||magnitudine>12) {
					throw new  MagnitudineException("il numero non e' compreso nell'intervallo!");
					}
				isValid = false;
			}catch ( MagnitudineException e) {
				System.out.println(e.getMessage());
			}catch(Exception exc) {
				s.reset();
				System.out.println("Input non valido");
			}
		}while(isValid==true);
		
		do {
			try {
				System.out.println("Inserisci la sua distanza dalla terra (km) ");
				String distanzaTerraStr = s.next();
				distanzaTerra = Float.parseFloat(distanzaTerraStr);
				if(distanzaTerra<0) {
					throw new Exception();
				}
				isValid = true;
			}catch(Exception exc) {
				System.out.println("input non valido");
			}
		}while(isValid==false);
		
		System.out.println("di che tipo di oggetto si tratta? (1- oggetto semplice, 2- esopianeta, 3- stella");
		int opz = s.nextInt();
		OggettoExtrasolare ogg = null;
		switch(opz) {
		case 1:
			float diametro=0;
			do{
				try {
			System.out.println("Inserisci il diametro di questo oggetto semplice (km):");
				String diametroStr = s.next();
				 diametro = Float.parseFloat(diametroStr);
				 isValid = false;
				 
				 if(diametro<0) {
					 throw new Exception();
				 }
				}catch(Exception exc) {
					System.out.println("Input non valido");
				}
			}while(isValid==true);
			ogg = new OggettoSemplice(nome,magnitudine,distanzaTerra,diametro);
			break;
			
		case 2:
				int satelliti =0;
			do {
				try {
					System.out.println("Quanti satelliti ha l'esopianeta?");
					String satellitiStr = s.next();
					satelliti = Integer.parseInt(satellitiStr);
					if(satelliti<0) {
						throw new Exception();
					}
					isValid=false;
				}catch(Exception exc) {
					System.out.println("Input non valido");
				}
			}
			while(isValid==true);
			ogg = new Esopianeta(nome,magnitudine,distanzaTerra,satelliti);
			break;
			
		case 3:
			Colore colore = null;
			System.out.println("A che temperatura si trova la stella? (°C)");
			float temperaturaGradi = s.nextFloat();
			boolean valid = true;
			while(valid == true) {
			System.out.println("Inserisci il colore della stella (1- blu, 2- bianco, 3- giallo, 4- rosso");
				switch(s.nextInt()) {
				case 1: colore = Colore.BLU;
						valid = false;
					break;
				case 2: colore = Colore.BIANCO;
						valid = false;
					break;
				case 3: colore = Colore.GIALLO;
						valid = false;
					break;
				case 4: colore = Colore.ROSSO;
						valid = false;
					break;
				}
			}
				ogg = new Stella(nome,magnitudine,distanzaTerra,temperaturaGradi,colore);
			break;
		}
		return ogg;
		
	}
	public void aggiungiOggetto(OggettoExtrasolare ogg) {
		elencoOggetti[index++] = ogg;
	}
	public void visualizzaOggetti() {
		for (int i=0; i<index; i++) {
			System.out.println(elencoOggetti[i].toString());
		}
	}
	public void visualizzaDettaglio(String nome) {
		for (int i=0; i<index; i++) {
			if(nome.equals(elencoOggetti[i].getNome())) {
				System.out.println(""+(i+1)+"-"+elencoOggetti[i].toString());
			}
		}
	}
	public void ricercaOggetto(int magnitudine) throws OggettoNotFoundException {
		OggettoExtrasolare ogg =null;
		
		for (int i=0; i< index;i++) {
			if (elencoOggetti[i].getMagnitudine() == magnitudine) {
				ogg = elencoOggetti[i];
				System.out.println(ogg.toString());
			}
		}
		if(ogg == null) {
			throw new OggettoNotFoundException("non e stato trovato nessun oggetto con questa magnitudine!");
		}
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- Inserisci un'oggetto extrasolare;");
		System.out.println("2- Visualizza tutti gli oggetti inseriti;");
		System.out.println("3- Visualizza un dettaglio particolare di un oggetto;");
		System.out.println("4- Ricerca un oggetto da una magintudine;");
		System.out.println("5- Uscita;");
		System.out.println("Scegli: ");
		return s.nextInt();
	}
	public static void main (String[]args) {
		OggettiExtrasolari ogEx = new OggettiExtrasolari();
		int opz = 0;
		OggettoExtrasolare ogg = null;
		
		do {
			opz = ogEx.menuUtente();
			switch (opz) {
			case 1: 
				ogg =  ogEx.inserisciOggetto();
				ogEx.aggiungiOggetto(ogg);
			case 2: ogEx.visualizzaOggetti();
				break;
			case 3:
				System.out.println("Qual'e il nome dell'oggetto? ");
				String nome = s.next();
				ogEx.visualizzaDettaglio(nome);
				break;
			case 4:
				System.out.println("Qual'e la magitudine dell'oggetto? ");
				int magnitudine = s.nextInt();
				try {
					ogEx.ricercaOggetto(magnitudine);
				} catch (OggettoNotFoundException exc) {
					System.out.println(exc.getMessage());
				}
				break;
			case 5:
				System.out.println("Arrivederci!");
				break;
			}
		}while(opz!=5);
	}
}
