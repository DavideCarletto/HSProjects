package esercizio2;

import java.io.File;
import java.util.TreeMap;

public interface UtenteService {

	public TreeMap<Integer, Utente> caricaUtentiCsv(File f);
	public Utente cercaUtente(TreeMap<Integer, Utente> elencoUtenti , Integer codice);
	public void visualizzaElencoUtenti(TreeMap<Integer, Utente> elencoUtenti);
	
}
