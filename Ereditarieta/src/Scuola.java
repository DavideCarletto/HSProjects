
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Scuola {

	private static final int NUM_MAX_PERSONA = 1500;
	private Persona[] listaPersona;
	private int index;
	
	public Scuola() {
		listaPersona = new Persona[NUM_MAX_PERSONA];
		index=0;
		
	}
	
	public void inserisciNuovoStudente(){
		Scanner s = new Scanner(System.in);
		System.out.println("Immetti il cognome");
		String cognome = s.next();
		System.out.println("Immetti il nome");
		String nome = s.next();
		System.out.println("Immetti la matricola");
		String matricola = s.next();
		System.out.println("Immetti la data di nascita (gg/mm/aaaa):");
		String dataStr = s.next();
		GregorianCalendar cal = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date d = sdf.parse(dataStr);
				cal = new GregorianCalendar();
				cal.setTime(d);
				
			}catch(ParseException e) {
				e.printStackTrace();
			}
		Persona st = new Studente(cognome, nome, matricola);
		st.setDataNascita(cal);
		listaPersona[index++] = (Studente)st;
		((Studente)st).stampaDati();
		}
	public void visuaizzaStudenti() {
				for (int i =0; i<index; i++) {
			if ((listaPersona[i]!=null)&&(listaPersona[i] instanceof Studente)) {
				Studente s = (Studente)listaPersona[i];
			}
		}
	}
	
	
	public static void main(String[]args) {
		Scuola sc = new Scuola();
		sc.inserisciNuovoStudente();
	}
}
