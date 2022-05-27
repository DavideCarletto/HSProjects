import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GestioneProdotti {
	Scanner s = new Scanner(System.in);
	Prodotto[] elencoProdotti = null;
	private int index = 0;
	
	public GestioneProdotti() {
		elencoProdotti = new Prodotto[100];
	}
	public Prodotto creaProdotto() {
		Prodotto p = null;
		
		System.out.println("Inserisci il suo codice: ");
		int codice = s.nextInt();
		System.out.println("Inserisci una breve descrizione del prodotto: ");
		String descrizione = s.next();
		System.out.println("Inserisci il suo prezzo: ");
		float prezzo = s.nextFloat();
		System.out.println("di che prodotto si tratta? (1- alimentare 2- ferramenta)");
		int scelta = s.nextInt();
		TipoProdottoFerramenta tipo = null;
		
			switch (scelta) {
			case 1: System.out.println("Qual'e' la sua data di scadenza? (gg/mm/aaaa/)");
					String dataScad = s.next();
					GregorianCalendar cal = null;
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date d = sdf.parse(dataScad);
					cal = new GregorianCalendar();
					cal.setTime(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					p = new ProdottoAlimentare (codice,descrizione,prezzo,cal);
					break;
			case 2:  System.out.println("e' di tipo hobbistico o professionale? (1- hobbistico, 2- professionale)");
					boolean valid = false;
					
					while(valid == false) {
					switch (s.nextInt()) {
					
					case 1: tipo = TipoProdottoFerramenta.HOBBISTICO;
							valid = true;
					break;
					case 2: tipo = TipoProdottoFerramenta.PROFESSIONALE;
							valid = true;
					break;
					}
					
					}
					p = new ProdottoFerramenta(codice,descrizione,prezzo,tipo);
			}
			return p;
	}
	public void catalogaProdotto(Prodotto p) {
		elencoProdotti[index++] = p;
	}	
	public void visualizzaProdotti() {
		for (int i = 0; i<index; i++) {
			
			}
		}
	
	public int Menu (){ 
		System.out.println("MENU UTENTE");
		System.out.println("1- cataloga un prodotto");
		System.out.println("2- visualizza i prodotti catalogati");
		System.out.println("3- uscita");
	
		return s.nextInt();
	}
	
	public static void main(String[] args) {
		GestioneProdotti gProd = new GestioneProdotti();
		int opz = 0;
		Prodotto p  = null;
		
		do {
			opz = gProd.Menu();
			switch(opz) {
			case 1: p = gProd.creaProdotto();
					gProd.catalogaProdotto(p);
				break;
			case 2:
				gProd.visualizzaProdotti();
				break;
			case 3:
				System.out.println("Arrivederci!");
				break;
			}
		}while(opz != 3);
		
	}

}
