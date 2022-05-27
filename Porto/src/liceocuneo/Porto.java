package liceocuneo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Porto {

	private ArrayList elencoNavi;
	private Scanner s;
	private static Porto porto;
	
	private Porto (){
		elencoNavi = new ArrayList<>();
		s = new Scanner (System.in);
		
	}
	public static Porto getInstance() {
		if(porto==null) {
			porto = new Porto();
		}
		return porto;
	}
	
	public Nave inserisciNave() {
		System.out.println("Inserisci la lunghezza della nave:");
		float lunghezza = s.nextFloat();
		System.out.println("Inserisci la larghezza della nave:");
		float larghezza = s.nextFloat();
		
		System.out.println("Inserisci la data d'arrivo (dd/MM/yyyy)");
		String date = s.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar data = null;
		try {
			Date d = sdf.parse(date);
			data = new GregorianCalendar();
			data.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Inserisci giorni permanenza");
		int ggPermanenza = s.nextInt();
		
		System.out.println("Inserisci la posizione attracco");
		int nPosizoneAttracco = s.nextInt();
		
		System.out.println("Inserisci la compagnia");
		String compagnia = s.next();
		
		System.out.println("1-Nave passeggeri, 2- nave merci");
		int opz = s.nextInt();
		Nave nave = null;
		switch(opz) {
		case 1:
			System.out.println("inserisci il numero di passeggeri:");
			int nPasseggeri = s.nextInt();
			nave = new NavePasseggeri(lunghezza,larghezza,data,ggPermanenza,nPosizoneAttracco,compagnia,nPasseggeri);
			break;
			
		case 2:
			nave = new NaveMerci(lunghezza,larghezza,data,ggPermanenza,nPosizoneAttracco,compagnia);
			break;
		}
		return nave;
	}
	
	public void aggiungiNave(Nave n) {
		elencoNavi.add(n);
	}
	public void visualizzaNavi() {
		for(int i=0; i<elencoNavi.size();i++) {
			System.out.println("nave:"+elencoNavi.get(i).toString());
		}
	}
	
	public void ricercaNavi() {
		
	}
	
	public int menuUtente () {
		System.out.println("MENU UTENTE");
		System.out.println("1- registra dati nave");
		System.out.println("2- visualizza tutte le navi");
		System.out.println("3- ricerca navi in partenza per una determinata data");
		System.out.println("4-uscita");
		System.out.print("Scegli:");
		return s.nextInt();
	

		
	}
	
	public static void main(String[]args) {
		Porto p = Porto.getInstance();
		int opz = 0;
		Nave n = null;
		
		do {
			opz = p.menuUtente();
			
			switch(opz) {
			case 1:
				n = p.inserisciNave();
				p.aggiungiNave(n);
				break;
			case 2:
				p.visualizzaNavi();
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}while(opz!=4);
	
	}
}
