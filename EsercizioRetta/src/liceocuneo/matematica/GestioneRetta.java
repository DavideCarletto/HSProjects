package liceocuneo.matematica;
import liceocuneo.util.Tastiera;

public class GestioneRetta {
	
	private Tastiera t;
	
	public GestioneRetta() {
		t = new Tastiera();
	}
	
	public Retta immettiRetta() {
		int m = t.leggiNumeroIntero("Immetti il valore di m:");
		int q = t.leggiNumeroIntero("Immetti il valore di q:");
		Retta r = new Retta(m, q);
		return r;
	}
	
	
	public Punto immettiPunto() {
		int x = t.leggiNumeroIntero("Immetti il valore di x:");
		int y = t.leggiNumeroIntero("Immetti il valore di y:");
		Punto p = new Punto(x, y);
		return p;
	}
	
	/**
	 * visualizza il menu utente e restituisce l'opzione selezionata
	 * @return
	 */
	public int menuUtente() {
		System.out.println("MENU APPLICAZIONE");
		System.out.println("1. crea retta.");
		System.out.println("2. verifica appartenenza origine.");
		System.out.println("3. verifica appartenenza punto.");
		System.out.println("4. visualizza equazione esplicita.");
		System.out.println("5. uscita");
		return t.leggiNumeroIntero("Immetti l'opzione desiderata:");
	}
	

	public static void main(String[] args) {
		GestioneRetta gRetta = new GestioneRetta();
		Retta r1 = null;
		int opz;
		do {
			opz = gRetta.menuUtente();
			switch(opz) {
			case 1: {
				r1 = gRetta.immettiRetta();
				break;
			}
			case 2: {
		
					boolean ris = r1.verificaPassaPerOrigine();
					if(ris == true) {
						System.out.println("La retta passa per l'origine\n");
					}
					else {
						System.out.println("La retta NON passa per l'origine\n");
					}
				
				break;
			}
			case 3: {
				Punto p1 = gRetta.immettiPunto();
				if((p1 != null)) {
					boolean ris = r1.verificaAppartenenzaPunto(p1);
					if(ris == true ) {
						System.out.println("La retta passa per il punto inserito");
					}
					else {
						System.out.println("La retta NON passa per il punto inserito");
					}
				}
				break;
			}
			case 4: {
				if(r1 != null) {
					r1.visualizzaEquazioneEsplicita();
				}
				break;
			}
			case 5: {
				System.out.println("Arrivederci!");
				break;
			}
			}
		}while((opz != 5) || (r1==null));
		

	}

}
