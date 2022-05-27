import java.util.Scanner;

public class Aerodromo {

	private Aeromobile elencoAerei[];
	private int index;
	Scanner s = new Scanner (System.in);
	
	public Aerodromo () {
		elencoAerei = new Aeromobile[100];
		index = 0;
	}
	
	public void creaAereo() {
		System.out.println("inserisci la sigla dell'aereo");
		String sigla = s.next();
		Aeromobile ar = null;
		
		System.out.println("Si tratta di un aliante o di un Aereomotore? (1,2)");
		switch(s.nextInt()) {
		case 1: 
			System.out.println("inserisci il numero di efficienza:");
			int numEff = s.nextInt();
			ar = new Aliante (sigla,numEff);
		case 2: 
			System.out.println("Inserisci la potenza Cv");
			double potenzaCv = s.nextDouble();
			ar = new AereoMotore (sigla,potenzaCv);
			
		}
		elencoAerei[index++] = ar;
	
	}
	
	public static void main (String[] args) {
		
	}
}
