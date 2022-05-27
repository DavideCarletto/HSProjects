package Articoli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Quotidiano {

	private static final int NUM_MAX_ARTICOLI = 100;
	private Articolo elencoArticoli[];
	private int index;
	private static Scanner s = new Scanner(System.in);
	
	public Quotidiano() {
		elencoArticoli = new Articolo[NUM_MAX_ARTICOLI];
		index = 0;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Articolo[] getElencoArticoli() {
		return elencoArticoli;
	}

	public Articolo inserisciArticolo() {
		boolean isValid = false;
		int identificativo =0;
		String titolo = null;
		String nome = null;
		String cognome = null;
		do {
			try {
				System.out.println("Inserisci l'identificativo del nome: ");
				String identificativoStr = s.next();
				identificativo = Integer.parseInt(identificativoStr);
				isValid = true;
			}catch(Exception e ) {
				System.out.println("Input non valido ");
			}
		}while(isValid==false);
		
		do {
			try {
				System.out.println("Qual'e il titolo dell'articolo? ");
				titolo = s.next();
				isValid = false;
			}catch(Exception e ) {
				System.out.println("Input non valido ");
			}
		}while(isValid==true);

		System.out.println("Contenuto: ");
		String contenuto = s.next();
			
		System.out.println("Data pubblicazione: (dd/mm/yyyy)");
		String data = s.next();
		GregorianCalendar dataPubb = null;
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {
			Date d  = sdf.parse(data);
			dataPubb = new GregorianCalendar();
			dataPubb.setTime(d);
			isValid = true;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		do {
			try {
			System.out.println("Autore- Nome:");
			nome = s.next();
			isValid = false;
			}catch(Exception e) {
			System.out.println("input non valido ");
			}
		}while(isValid==true);
		
		do {
		try {
			System.out.println("Autore- Cognome:");
			cognome = s.next();
			isValid = true;
			}catch(Exception e ) {
				System.out.println("input non valido ");
			}
		}while(isValid==false);
		 Autore a  = new Autore(nome, cognome);
		 
		 Articolo art = new Articolo (identificativo,titolo,contenuto,dataPubb,a);

		addArticolo(art);
		return art;
	}
	
	public void addArticolo(Articolo a ) {
		elencoArticoli[index++] = a;
	}
	public Quotidiano elencoArticoliAtuore(Autore a ){
		Quotidiano quotidianoAutore = new Quotidiano();
		for (int i = 0; i<index;i++) {
			if(elencoArticoli[i].getAutore().equals(a)) {
				quotidianoAutore.getElencoArticoli()[quotidianoAutore.getIndex()] = elencoArticoli[i];
				quotidianoAutore.setIndex(quotidianoAutore.getIndex()+1);
				}
		}
		return quotidianoAutore;
	}
	public int getNumParole(Articolo a) throws NessunContenutoExcpetion {
		int conta = 0;
		int posizioneIn = 0;
		int posizioneFin =0;

		do {
			 posizioneFin = a.getContenuto().indexOf(" ",posizioneIn);
			if(posizioneFin>=0) {
			posizioneIn = posizioneFin;
			conta++;
			}
		}while(posizioneFin>=0);
		if (conta == 0) {
			throw new NessunContenutoExcpetion("nessuna parola inserita");
		}
		return conta;
	}
	public static void main (String[]args) {
		Quotidiano q = new Quotidiano();
		Articolo a = q.inserisciArticolo();
		String nome = s.next();
		String cognome = s.next();
		Autore au = new Autore(nome,cognome);
		q.elencoArticoliAtuore(au);
		try {
			q.getNumParole(a);
		} catch (NessunContenutoExcpetion e) {
			System.out.println(e.getMessage());
		}
	}
	
}
