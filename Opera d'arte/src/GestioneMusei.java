import java.util.Scanner;

public class GestioneMusei {
	
	private  Scanner s = new Scanner (System.in);
	private int index = 0;
	private static final int NUM_MAX_MUSEI= 20;
	private Museo elencoMusei[];
	
	public GestioneMusei(){
		elencoMusei = new Museo[NUM_MAX_MUSEI];
	}	
	public Museo creaMuseo() {
		System.out.println("Inserisci il nome del museo: ");
		String nome = s.next();
		System.out.println("Inserisci dove si trova il museo:");
		String luogo = s.next();
		
		Museo m = new Museo (nome,luogo);
		return m;
	}
	
	public void aggiungiMuseo(Museo m) {
		elencoMusei[index++] = m;
	}
	
	public void visualizzaMusei() {
		
		for (int i=0; i<index; i++) {
			System.out.println(""+(i+1)+"- "+elencoMusei[i].toString());
		}
	}
	public void caricaOpera() {
		System.out.println("In che museo si trova l'opera?");
		int scelta = s.nextInt()-1;
		
		if (elencoMusei[scelta]!=null) {
			OperaArte opera = null;
			System.out.println("Inserisci il nome dell' opera: ");
			String nome = s.next();
			System.out.println("Inserisci l'altezza dell'opera (in cm):");
			float altezza = s.nextFloat();
			System.out.println("Inserisci la larghezza dell'opera (in cm): ");
			float larghezza = s.nextFloat();
			System.out.println("Inserisci il suo peso (in kg): ");
			int peso = s.nextInt();
			System.out.println("Di che tipo di opera si tratta? (1- pittura, 2- scultura)");
			switch(s.nextInt()) {
			case 1:	 opera = new Pittura(nome, altezza,larghezza,peso);
				break;
			case 2:	System.out.println("Inserisci la profondita della scultura (in cm): ");
					float profondita = s.nextFloat();
					opera = new Scultura (nome, altezza, larghezza, profondita,peso);
				break;
			}
			elencoMusei[scelta].aggiungiOpera(opera);
		}
	}
	public void visualizzaOpere() {
		if (elencoMusei != null) {
			for (int i=0; i<index; i++) {
				
					System.out.println("Museo numero "+(i+1)+": ");
					elencoMusei[i].visualizzaOpere();
				}
			
		}
	}
	public void spostaOpera() {
	
		System.out.println("in quale museo si trova l'opera da spostare? ");
		int scelta = s.nextInt()-1;
			if (elencoMusei[scelta] != null) {
				elencoMusei[scelta].visualizzaOpere();
				System.out.println("Quale opera si desidera spostare? ");
				int opz = s.nextInt()-1;
				elencoMusei[scelta].getElencoOpere()[opz].ingombro();
				System.out.println("Il peso totale dell'opera e di "+elencoMusei[scelta].getElencoOpere()[opz].getPeso()+" kg");
					if(elencoMusei[scelta].getElencoOpere()[opz]!=null) {
						System.out.println("in quale museo si desidera spostare? ");
						int sceltaMuseo = s.nextInt()-1;
							if (elencoMusei[sceltaMuseo] != null) {
							elencoMusei[sceltaMuseo].aggiungiOpera(elencoMusei[scelta].getElencoOpere()[opz]);
							elencoMusei[scelta].getElencoOpere()[opz] = null;
							}
					}
					else{
						System.out.println("Opera gia trasferita");
					}
			}
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- crea museo");
		System.out.println("2- caricare opere d'arte (all'interno di un museo)");
		System.out.println("3- visualizza tutte le opere");
		System.out.println("4- trasferimento opera");
		System.out.println("5- uscita");
		System.out.println("Inserisci l'opzione desiderata:");
		
		return s.nextInt();
	}
		public static void main (String[]args) {
			
			
			
			}
		}
	
	