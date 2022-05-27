package liceocuneo.Nave;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Porto {

	private Nave[] elencoNavi;
	private int index;
	Scanner s = new Scanner (System.in);
	
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Nave[] getElencoNavi() {
		return elencoNavi;
	}

	public Porto() {
		elencoNavi = new Nave[50];
		index=0;
	}
	
	public Nave registraNave() {
		System.out.println("Inserisci la lunghezza della nave");
		float lunghezza = s.nextFloat();
		
		System.out.println("Inserisci la larghezza");
		float larghezza = s.nextFloat();
		
		int scelta =0;
		do {
		System.out.println("Inserisci il tipo (1-Passeggeri, 2-merci)");
		 scelta = s.nextInt();
		}while(scelta>2||scelta<1);
		
		int nPasseggeri=0;
		Tipo tipo=null;
		switch(scelta) {
		case 1: System.out.println("Inserisci il numero di passeggeri a bordo:");
				tipo = Tipo.PASSEGGERI;
				nPasseggeri = s.nextInt();
				break;
		case 2: tipo = Tipo.MERCI;
				nPasseggeri =0;
				break;
		}
		
		System.out.println("Inserisci la data d'arrivo (dd/MM/yyyy)");
		String date = s.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar data= null;
		try {
			Date d = sdf.parse(date);
			data = new GregorianCalendar();
			data.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inserisci la'ora di arrivo");
		int oraArrivo = s.nextInt();
		
		System.out.println("Inserisci il tempo di permanenza in ore");
		int permanenza = s.nextInt();
		
		System.out.println("Inserisci il numero posizione attracco:");
		int nPosizioneAttr = s.nextInt();
		
		System.out.println("Inserisci il nome della compagnia");
		String compagnia = s.next();
		
		Nave n = new Nave (lunghezza,larghezza,tipo,data,oraArrivo,permanenza,nPosizioneAttr,compagnia,nPasseggeri);
		return n;
	}
	
	public void aggiungiNave(Nave n) throws PortoPienoException{
		if(elencoNavi!=null){
			if(index==50) {
				throw new PortoPienoException("porto gia pieno!");
			}else {
				elencoNavi[index++]= n;
			}
			
		}
		
	
	}
	
	public Porto ricercaNavi (GregorianCalendar data, int ora){
		Porto p= new Porto();
		
		for (int i=0; i<index;i++) {
			if((elencoNavi!=null)) {
				p.getElencoNavi()[i] = elencoNavi[i];
				p.setIndex(p.getIndex()+1);
			}
		}
		return p;
		
	}
	public void visualizzaNavi() {
		for(int i=0; i<index;i++) {
		System.out.println(""+(i+1)+"- "+elencoNavi[i].toString());
		}
	}
	
	
	public static void main (String[]args) {
		Porto p = new Porto();
		Nave n = p.registraNave();
		try {
			p.aggiungiNave(n);
		} catch (PortoPienoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		p.visualizzaNavi();
		
		
		
	}
}
