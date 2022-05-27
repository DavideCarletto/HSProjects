import java.util.Scanner;

public class Centralina {

	private Parametro[] elencoParametri;
	private int index;
	private static final int NUM_MAX_PARAMETRI = 100;
	static Scanner s = new Scanner (System.in);
	
	public Centralina() {
		index=0;
		elencoParametri = new Parametro[NUM_MAX_PARAMETRI];
	}
	
	public void aggiungiParametro(Parametro p) {
		elencoParametri[index++] = p;
	}
	
	public Parametro creaParametro() {
		boolean valid = true;
		int cod=0;
		String descrizione = null;
		int valore=0;
		do {
			try {
		System.out.println("Inserisci il codice:");
		String codStr = s.next();
		 cod = Integer.parseInt(codStr);
		valid = false;
			}catch(Exception exc) {
				System.out.println("Input non valido");
			}
		
		}while(valid==true);
		
		System.out.println("Inserisci una piccola descrizione del parametro:");
		String descrzione = s.next();
		do {
			try {
		System.out.println("Inserisci un valore numerico per il parametro:");
		String valStr = s.next();
		valore = Integer.parseInt(valStr);
		valid = true;
			}catch(Exception exc) {
				System.out.println("Input non valido");
			}
		
		}while(valid==false);

		System.out.println("Inserisci la sua categoria (1,2,3,4)");
		int scelta =0;
		do {
			try {
		String sceltaStr = s.next();
		 scelta = Integer.parseInt(sceltaStr);
		valid = false;
			}catch(Exception exc) {
				System.out.println("Input non valido");
			}
		
		}while(valid==true);
		Categoria cat = null;
		Parametro p =null;
		switch(scelta) {
		case 1: cat = Categoria.CAMBIO;
			break;
		case 2:	cat = Categoria.FRENI;
			break;
		case 3: cat = Categoria.MOTORE;
			break;
		case 4: cat = Categoria.SISTEMA_MULTIMEDIALE;
			break;
		}
		p = new Parametro (cod,descrizione,valore,cat);
		return p;
	}
	public void visualizzaParametri() {
		for (int i=0; i<index; i++) {
			System.out.println(""+(i+1)+"- "+elencoParametri[i].toString());
		}
	}
	
	public boolean esisteParametro(int cod) {
	
		boolean valore = false;
		
		for (int i=0; i<index; i++) {
			if (elencoParametri[i].getCod()==cod) {
				valore = true;
				break;
			}
		}
		return valore;
	}
	
	public static void main(String[]args) {
		Centralina centr = new Centralina();
		Parametro p =centr.creaParametro();
		centr.aggiungiParametro(p);
		centr.visualizzaParametri();
		boolean valid =true;
		int cod =0;
		do {
			try {
		System.out.println("Inserisci il codice:");
		String codStr = s.next();
		 cod = Integer.parseInt(codStr);
		valid = false;
			}catch(Exception exc) {
				System.out.println("Input non valido");
			}
		
		}while(valid==true);
		
		valid = centr.esisteParametro(cod);
		if(valid ==true) {
			System.out.println("si esiste gg");
		}else {
			System.out.println("no gg");
		}
		
		
	}
}
