package liceocuneo.forum;

import java.util.Calendar;

public class Commento {
	private String testo;
	private String utente;
	private Calendar dataOra;
	
	public Commento(String testo, String utente) {
		this.testo = testo;
		this.utente = utente;
	}
	public Commento (String testo) {
		this.testo = testo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public Calendar getDataOra() {
		return dataOra;
	}
	public void setDataOra(Calendar dataOra) {
		this.dataOra = dataOra;
	}
}
