import java.util.Scanner;

public class Distributore {
	private static final int NUM_MAX_CISTERNE = 3;
	private static final int NUM_MAX_COLONNINE = 6;
	Scanner s = new Scanner(System.in);
	int index = 0;
	Cisterna ci = null;
	int diffe1,diffe2,diffe3;
	
	Cisterna cisterne[];
	Colonnina colonne[];
	public Distributore() {
		super();
		cisterne = new Cisterna[NUM_MAX_CISTERNE];
		colonne = new Colonnina[NUM_MAX_COLONNINE];
	}
	
	public void caricaLitriePrezzi() {
		Carburante ca = null;
		float prezzo;
		TipologiaCarburante tipologia = null;
		for (int i=0; i<NUM_MAX_CISTERNE; i++) {
		 System.out.println("Inserisci il tipo di carburante:(1-benzina 2-gasolio 3-gasolio super)");
		boolean tipo =  false;
		
			while(tipo==false) {
				switch(s.nextInt()) {
				case 1:tipologia=TipologiaCarburante.BENZINA;
						System.out.println("Inserisci il prezzo della "+tipologia);
						prezzo = s.nextFloat();
						ca = new Carburante (prezzo,tipologia);
						tipo = true;
						break;
				case 2:tipologia=TipologiaCarburante.GASOLIO;
						System.out.println("Inserisci il prezzo del "+tipologia);
						prezzo = s.nextFloat();
						ca = new Carburante (prezzo,tipologia);
						tipo = true;
						break;
				case 3:tipologia=TipologiaCarburante.GASOLIO_SUPER;
						System.out.println("Inserisci il prezzo del "+tipologia);
						prezzo = s.nextFloat();
						ca = new Carburante (prezzo,tipologia);
						tipo = true;
						break;
				}
			}
			System.out.println("Quanti litri di "+tipologia+" vuoi caricare nella cisterna?");
			int litritot = s.nextInt();
			ci = new Cisterna (ca,litritot);
			cisterne[index++]=ci;
		}
	}
	public void rifornimento() {
		Colonnina co = null;
		Carburante ca = null;
		int i=0;
		int posizione;
		
		TipologiaCarburante tipologia = null;
		do {
		System.out.println("A quale colonnina si vuole fare rifornimento?");
		 posizione = s.nextInt();
		}while(NUM_MAX_COLONNINE>6);
		
		System.out.println("Quanti litri vuoi prendere?");
		int litririf = s.nextInt();
		System.out.println("Inserisci il tipo di carburante che vuoi prelevare:(1-benzina 2-gasolio 3-gasolio super)");
		
			switch(s.nextInt()) {
			case 1: for(i=0; i<NUM_MAX_CISTERNE;i++) {
				if(cisterne[i].carburante().getTipologia()==tipologia.BENZINA) {
					ca = cisterne[i].carburante();	
					diffe1 = cisterne[i].getLitriTot()-litririf;
				}
			}
					break;
			case 2:
				for(i=0; i<NUM_MAX_CISTERNE;i++) {
					if(cisterne[i].carburante().getTipologia()==tipologia.GASOLIO) {
						ca = cisterne[i].carburante();
						diffe1 = cisterne[i].getLitriTot()-litririf;
					}
				}
					break;
			case 3:
				for(i=0; i<NUM_MAX_CISTERNE;i++) {
					if(cisterne[i].carburante().getTipologia()==tipologia.GASOLIO_SUPER) {
						ca = cisterne[i].carburante();
						diffe1 = cisterne[i].getLitriTot()-litririf;
					}
				}
					break;
			}
			co = new Colonnina(litririf,ca);
			colonne[posizione] = co;

		
	}
	
	public void visualizzaLitrieRimanenze() {
		System.out.println("Litri forniti:");
		for (int i=0; i<NUM_MAX_COLONNINE;i++) {
			System.out.println("colonnina"+(i+1)+": "+colonne[i].getLitriRifornimento());
		}
		System.out.println("Cisterna 1:"+diffe1);
		System.out.println("Cisterna 2:"+diffe2);
		System.out.println("Cisterna 3:"+diffe3);
		
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- carica carburante e prezzi in cisterna");
		System.out.println("2- simula rifornimento");
		System.out.println("3- visualizza litri e rimanenze cisterne");
		System.out.println("4- uscita");
		System.out.println("Inserisci un'opzione:");
		return s.nextInt();
	}
	
	
	public static void main (String[]args) {
		Distributore d = new Distributore();
		int opz = 0;
		
			do {
				opz = d.menuUtente();
				
				switch(opz) {
				case 1: d.caricaLitriePrezzi();
					break;
				case 2:
						d.rifornimento();
					break;
				case 3:
					d.visualizzaLitrieRimanenze();
					break;
				case 4:
					break;
				}
			}while(opz!=4);
		}
}
 