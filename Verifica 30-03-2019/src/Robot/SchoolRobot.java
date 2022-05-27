package Robot;

import java.util.Scanner;

public class SchoolRobot {
	private Ordine elencoOrdini[];
	private int  index;
	private static Scanner s = new Scanner (System.in);
	
	public SchoolRobot() {
	index =0;
	}
	public Ordine inserisciOrdine() {
		return null;
	}
	public void stampaOrdini() {
		
		System.out.println("Inserisci l'ordine che vuoi visualizzare:");
		int sceltaOrdine=s.nextInt() ;
		
		System.out.println("Inserisci il robot  che vuoi visualizzare:");
		int sceltaRobot =s.nextInt(); 
		for (int i=0 ; i<elencoOrdini[sceltaOrdine-1].getElencoRobot().length; i++) {
			if(elencoOrdini[sceltaOrdine-1].getElencoRobot()[sceltaRobot-1]!=null) {
				elencoOrdini[sceltaOrdine-1].getElencoRobot()[sceltaRobot-1].stampaInformazioniDettaglio();
			}
		}
	}
	public static void main(String[]args) {
		SchoolRobot s = new SchoolRobot();
			
		
	}
}
