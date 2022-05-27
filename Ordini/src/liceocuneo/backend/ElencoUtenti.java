package liceocuneo.backend;
import java.util.ArrayList;

public class ElencoUtenti extends ArrayList<Utente> {

	public void aggiungiUtenti(Utente utente) {
		add(utente);
	}
	
	public void rimuoviUtente(Utente utente) {
		remove(utente);
	}
}
