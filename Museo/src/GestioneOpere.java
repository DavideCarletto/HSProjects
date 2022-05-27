import java.util.Scanner;

public class GestioneOpere {
	private Museo elencoMusei[];
	private int index = 0;
	Scanner s = new Scanner (System.in);
	
	public GestioneOpere(){
		elencoMusei = new Museo[100];
	}
	
	public Museo creaMuseo() {
		System.out.println("inserisci il nome del museo:");
		String nome = s.next();
		System.out.println("inserisci il luogo del museo:");
		String luogo = s.next();
		
		Museo m = new Museo(nome,luogo);
		return m;
		
	}
	public void aggiungiMuseo(Museo m) {
		elencoMusei[index++] = m;
	}
	public void aggiungiOpera() {
		visualizzaMusei();
		System.out.println("Inserisci il museo in cui si trova:");
		int scelta = s.nextInt();
		System.out.println("Inserisci il nome dell'opera");
		String nome = s.next();
		System.out.println("Inserisci il suo peso:");
		int peso = s.nextInt();
		System.out.println("Inserisci l'altezza");
		int altezza = s.nextInt();
		System.out.println("Inserisci la larghezza");
		int larghezza = s.nextInt();
		System.out.println("Pittura o scultura? (1- pittura, 2-scultura)");
		
		OperaArte opera = null;
		
		switch (s.nextInt()) {
		case 1:
			opera = new Pittura(nome,peso,altezza,larghezza,10);
			break;
		case 2:
			System.out.println("Inserisci la profondita della scultura:");
			int profondita = s.nextInt();
			opera = new Scultura(nome,peso,altezza,larghezza,profondita);
			break;
		}
		
		elencoMusei[scelta-1].addOpera(opera);
		
	}
	public void visualizzaMusei() {
		for (int i=0; i< index; i++) {
			System.out.println(""+(i+1)+"- "+elencoMusei[i].toString());
			
		}
	}
	public void visualizzaOpere() {
		
		for (int i=0; i<index; i++) {
			System.out.println("Museo numero "+(i+1));
			elencoMusei[i].visualizzaOpereMuseo();
		}
	}
	public void trasferimentoOpere() {
		
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- crea museo");
		System.out.println("2- aggiungi opera ad un museo");
		System.out.println("3- visualizza Opere");
		System.out.println("4- trasferimento opera");
		System.out.println("5- Uscita");
		System.out.println("Scegli: ");
		return s.nextInt();
		
	}
	
	public static void main (String[]args) {
		
		GestioneOpere gOp = new GestioneOpere();
		int opz = 0;
		Museo m =  null;
		
		do {
			opz = gOp.menuUtente();
			switch(opz) {
			case 1: m = gOp.creaMuseo();
					gOp.aggiungiMuseo(m);
				break;
			case 2:
					gOp.aggiungiOpera();
				break;
			case 3:
					gOp.visualizzaOpere();
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}while(opz != 5);
		
		
	}
	
}
