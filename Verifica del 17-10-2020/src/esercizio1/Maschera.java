package esercizio1;

public class Maschera {

	private String utente;
	private String password;
	public Maschera(String utente, String password) {
		super();
		this.utente = utente;
		this.password = password;
	}
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
	
	
}
