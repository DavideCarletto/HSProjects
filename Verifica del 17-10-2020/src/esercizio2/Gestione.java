package esercizio2;

import java.io.File;
import java.util.TreeMap;

public class Gestione {

	private TreeMap<Integer, Utente> elencoUtenti;

	public Gestione() {
		elencoUtenti = new TreeMap<>();

	}

	public void implementa() {
		UtenteService serv = UtenteServiceFactory.utenteServiceFactory();
		elencoUtenti = serv.caricaUtentiCsv(new File(
				"C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\Verifica del 17-10-2020\\src\\esercizio2\\UtenteCsv.csv"));
		serv.cercaUtente(elencoUtenti, 1234).toString();
		serv.visualizzaElencoUtenti(elencoUtenti);
	}

	public static void main(String[] args) {
		Gestione g = new Gestione();
		g.implementa();
	}

}
