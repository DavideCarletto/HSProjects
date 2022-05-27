package liceocuneo.matematica;
import liceocuneo.utill.Tastiera;

public class GestioneRetta {
	
	Tastiera t1 = new Tastiera();
	
	public Retta ImmettiRetta() {
		int m = t1.LeggiNumeroIntero("Immetti m:");
		int q = t1.LeggiNumeroIntero("immetti q:");
		Retta r = new Retta (m,q); 
		return r;
	}
	
	public Punto ImmettiPunto() {
		int x = t1.LeggiNumeroIntero("Immetti x: ");
		int y = t1.LeggiNumeroIntero("Immetti y:");
		Punto p = new Punto(x,y);
		return p;
	}
	
	public int MenuUtente() {
		
		System.out.println("MENU APPLICAZIONE");
		System.out.println("1. crea retta.");
		System.out.println("2. verifica appartenenza origine.");
		System.out.println("3. verifica appartenenza punto.");
		System.out.println("4. visualizza equazione esplicita.");
		System.out.println("5. uscita");
		
		return t1.LeggiNumeroIntero("Immetti un numero:");
	}
		public static void main(String[] args) {
			GestioneRetta gRetta = new GestioneRetta();
			Retta r1 = null;
			Punto p1 = null;
			int opz;
				do {
					opz= gRetta.MenuUtente();
				switch (opz) {
				
					case 1:
							r1 = gRetta.ImmettiRetta();
							break;
							
					case 2:
						boolean ris = r1.verificaPassaPerOrigine();
						if (ris == true )
							System.out.println("La retta passa per l'origine");
						else 
							System.out.println("La retta non passa per l'origine");
						break;
						
					case 3: p1 = gRetta.ImmettiPunto();
							boolean risultato = r1.verificaAppartenenzaPunto(p1);
							if (risultato == true)
								System.out.println("il punto inserito p appartiene alla retta");
							else
								System.out.println("il punto inserito p non appartiene alla retta");
							break;
							
					case 4: r1.visualizzaEquazioneEsplicita();
						break;
						
					case 5:
						System.out.println("Arrivederci!");
						break;
				}
			}while(opz!=5);
		}
	}

