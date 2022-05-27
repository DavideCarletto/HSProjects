package portoNavi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Porto {
	
	private Nave[] elencoNavi;
	private static final int NUM_MAX_NAVI = 50;
	private int index;
	static Scanner sc = new Scanner(System.in);
	
	public Porto(){
		elencoNavi = new Nave[NUM_MAX_NAVI];
		index = 0;
	}
	
	public Nave[] getElencoNavi() {
		return elencoNavi;
	}

	public void setElencoNavi(Nave[] elencoNavi) {
		this.elencoNavi = elencoNavi;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Nave creaNave() {
		System.out.println("Inserisci la lunghezza: ");
		float lunghezza = sc.nextFloat();
		
		System.out.println("Inserisci la larghezza: ");
		float larghezza = sc.nextFloat();
		
		TipoNave tipo = null;
		int numPas = 0;
		switch(menuTipo()) {
		case 1:{
			System.out.println("Inserisci il numero di passeggeri");
			numPas = sc.nextInt();
			tipo = TipoNave.PASSEGGERI;
			break;
		}
		case 2:{
			tipo = TipoNave.MERCI;
			break;
		}
		}
		
		System.out.println("Inserisci la data di arrivo (dd/MM/yyyy)");
		String data = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		GregorianCalendar cal = null;
		try {
			Date d = sdf.parse(data);
			cal = new GregorianCalendar();
			cal.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserisci l'ora di arrivo: ");
		String ora = sc.next();
		
		System.out.println("Inserisci il tempo di permanenza: ");
		int tempo = sc.nextInt();
		
		System.out.println("Inserisci la posizione di attracco ");
		int pos = sc.nextInt();
		
		System.out.println("Inserisci il nome della compagnia: ");
		String nome = sc.next();
		
		Nave n = new Nave(lunghezza, larghezza, tipo, numPas, cal, ora, tempo, pos, nome);
		return n;
	}
	
	public int menuTipo() {
		System.out.println("Inserisci il tipo della nave");
		System.out.println("1) PASSEGGERI");
		System.out.println("2) MERCI");
		
		int scelta = sc.nextInt();
		return scelta;
	}
	
	public void aggiungiNave(Nave n) throws PortoPienoException{
		if ((elencoNavi[NUM_MAX_NAVI-1] == null)&&(n != null)) {
			elencoNavi[index++] = n;
		}
		else {
			throw new PortoPienoException("Il porto pieno! Riorovate domani");
		}
	}
	
	public void VisualizzaNavi() {
		for(int i =0; i<index; i++) {
			if(elencoNavi[i] != null) {
				System.out.println(elencoNavi[i].toString());
			}
		}
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- inserisci nave");
		System.out.println("2- visualizza navi");
		System.out.println("3- cerca nave per nome");
		System.out.println("4- Uscita");
		System.out.println("Scegli:");
		return sc.nextInt();
	}
	
	public Porto ricercaNave (Calendar data) {
		Porto p = new Porto();
		for(int i = 0; i<index; i++) {
			if(data.getTime().equals(elencoNavi[i].getData().getTime())) {
				p.getElencoNavi()[p.getIndex()] = elencoNavi[i];
				p.setIndex(p.getIndex()+1);
				System.out.println(elencoNavi[i].toString());
			}
		}
		return p;
	

		}
	public static void main (String []args) {
		Porto p = new Porto ();
		int opz =0;
		Nave n = null;
		
		do {
			opz = p.menuUtente();
			switch(opz) {
			case 1:
				n = p.creaNave();
				try {
					p.aggiungiNave(n);
				} catch (PortoPienoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				p.VisualizzaNavi();
				break;
			case 3:
				System.out.println("Inserisci la data dell nave:");
				String data = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
				GregorianCalendar cal = null;
				try {
					Date d = sdf.parse(data);
					cal = new GregorianCalendar();
					cal.setTime(d);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p.ricercaNave(cal);
				break;
			case 4:
				System.out.println("ciau kiwa :) <3 ");
				break;
			}
		}while(opz != 4);
	}
	}
