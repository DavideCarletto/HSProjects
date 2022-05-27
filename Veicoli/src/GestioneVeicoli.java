import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GestioneVeicoli {

	 Scanner s = new Scanner(System.in);
	 private static final int NUM_MAX_VEICOLI = 100;
	 private Veicolo[] elencoVeicoli = null;
	 private Veicolo[] elencoVeicoliVenduti = null;
	 private int index = 0;
	 private int index2 = 0;
	
	 public GestioneVeicoli() {
		 elencoVeicoli = new Veicolo[NUM_MAX_VEICOLI];
		 elencoVeicoliVenduti = new Veicolo[NUM_MAX_VEICOLI];
	 }
	 public Veicolo creaVeicolo() {
		 System.out.println("Inserisci la sua targa: ");
		 String targa = s.next();
		 System.out.println("Inserisci il suo prezzo: ");
		 float prezzo = s.nextFloat();
		 System.out.println("Inserisci l'anno di immatricolazione (gg/mm/aaaa)");
		 String cal = s.next();
		 GregorianCalendar annoImmatricolazione = null;
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 try {
			Date d = sdf.parse(cal);
			annoImmatricolazione = new GregorianCalendar();
			annoImmatricolazione.setTime(d);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Di che veicolo si tratta? (1- autocarro, 2- autoveicolo, 3- motoveicolo");
		 int scelta = s.nextInt();
		 Veicolo v = null;
		 
		 switch(scelta) {
		  case 1:  System.out.println("Inserisci il suo carico massimo (in ton): ");
		  			int qtaMax = s.nextInt();
		  			v = new Autocarro(targa,prezzo,annoImmatricolazione,qtaMax);
			  break;
			  
		  case 2: System.out.println("Inserisci la sua cilindrata: ");
		  		  int cilindrata = s.nextInt();
		  		  System.out.println("Inserisci il suo numero di porte: ");
		  		  int numPorte = s.nextInt();
		  		  v = new Autoveicolo(targa,prezzo,annoImmatricolazione,cilindrata,numPorte);
		  	  break;
			  
		  case 3:  System.out.println("Inserisci la sua categoria (1- da strada, 2- fuori strada, 3- scooter) ");
		  		   int opzione = s.nextInt();
		  		   Categoria tipo = null;
  		           boolean valid = false;
  		           while(valid == false) {
  		        	switch(opzione) {
  		        	  case 1: tipo = Categoria.DA_STRADA;
  		        	   	valid = true;
  		        	   break;
  		        	  case 2: tipo = Categoria.FUORI_STRADA;
  				      	valid = true;
  				      break;
  		        	  case 3: tipo = Categoria.SCOOTER;
  		        	  	valid = true;
  		        	  break;
  			  }
  		  }
  		  v = new Motoveicolo(targa,prezzo,annoImmatricolazione,tipo);
			  break;
		 }
		 return v;
	 }
	public void aggiungiVeicolo(Veicolo v) {
		elencoVeicoli[index++] = v;
	 }
	 public void venditaVeicolo() {
		 System.out.println("Si inserisca il numero dell'auto corrispondente che si vuole vendere");
		 int scelta = s.nextInt()-1;
		 Veicolo v = null;
		 if ((scelta<=index)&&(scelta>=0)&&(elencoVeicoli[scelta]!=null)) {
			elencoVeicoliVenduti[index2++]= elencoVeicoli[scelta];
			 v = elencoVeicoli[scelta];
			 elencoVeicoli[scelta] = null;
			
		 }
		 else 
		System.out.println("Spiacente, non e possibile effettuare questa operazione");
		 
	 }
	
	 public void calcoloRicavo() {
		 float ricavoAutocarro = 0;
		 float ricavoAutoveicolo = 0;
		 float ricavoMotoveicolo = 0;
		 
		for (int i=0; i<index2; i++) {
			if((elencoVeicoliVenduti[i]!=null)) {
			
				if (elencoVeicoliVenduti[i] instanceof Autocarro) {
					ricavoAutocarro += elencoVeicoliVenduti[i].getPrezzo();
				}
				if (elencoVeicoliVenduti[i] instanceof Autoveicolo) {
					ricavoAutoveicolo += elencoVeicoliVenduti[i].getPrezzo();
				}
				if (elencoVeicoliVenduti[i] instanceof Motoveicolo) {
					ricavoMotoveicolo += elencoVeicoliVenduti[i].getPrezzo();
				}
			
			}
		 
		}
		StampaDati(ricavoAutocarro,ricavoAutoveicolo,ricavoMotoveicolo);
		
	 }
	 public void visualizzaVeicoli() {
		 for(int i=0; i<index; i++) {
		System.out.println(""+(i+1)+""+elencoVeicoli[i].toString());
		
		 }
	 }
	 public void StampaDati(float ricavoAutocarro,float ricavoAutoveicolo,float ricavoMotoveicolo) {
		 System.out.println("Ricavo autocarro: "+ricavoAutocarro);
		 System.out.println("Ricavo autoveicolo: "+ricavoAutoveicolo);
		 System.out.println("Ricavo motoveicolo: "+ricavoMotoveicolo);
	 }
	 public int MenuUtente() {
		 System.out.println("MENU UTENTE");
		 System.out.println("1- Inserimento dati dei veicoli da tastiera");
		 System.out.println("2- Vendita di un veicolo");
		 System.out.println("3- Calcolo totale del ricavo per ogni tipologia di veicolo");
		 System.out.println("4- Visualizza veicoli registrati");
		 System.out.println("5- Uscita");
		 
		 return s.nextInt();
	 }
	 
	 public static void main(String[]args) {
		 GestioneVeicoli gV = new GestioneVeicoli();
		 int opz = 0;
		 Veicolo v = null;
		 do {
			 opz = gV.MenuUtente();
			 switch(opz) {
			 
			 case 1: v = gV.creaVeicolo();
			 		gV.aggiungiVeicolo(v);
				 break;
			 case 2:
				 	gV.venditaVeicolo();
				 break;
			 case 3:
				 	gV.calcoloRicavo();
				 break;
			 case 4:
				 gV.visualizzaVeicoli();
				 break;
			 case 5:
				 System.out.println("Arrivederci!");
				 break;
			 }
		 }while(opz!=5);
		 
	 }
}
