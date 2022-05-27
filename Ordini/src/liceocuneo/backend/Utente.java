package liceocuneo.backend;

public class Utente {

	private int id;
	private String nome;
	private String cognome;
	private String  utente;
	private String  password;
	private ElencoUtenti elencoUtenti;
	public Utente(int id, String nome, String cognome, String utente, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.utente = utente;
		this.password = password;
		elencoUtenti = new ElencoUtenti();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", utente=" + utente + ", password="
				+ password +"]";
	}
	
	
	
	
}
