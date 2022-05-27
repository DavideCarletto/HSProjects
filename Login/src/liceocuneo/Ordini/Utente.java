package liceocuneo.Ordini;

public class Utente {

	private int index;
	private String utente;
	private String password;
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utente(String utente, String password) {
		super();
		this.utente = utente;
		this.password = password;
	}
	
	
}
