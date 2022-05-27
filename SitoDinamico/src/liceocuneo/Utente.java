package liceocuneo;

public class Utente {

	private int index;
	private String nome;
	private String cognome;
	private String user;
	private String psd;
	private ElencoProdotti elencoProdotti;

	public Utente(String nome, String cognome, String user, String psd) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.user = user;
		this.psd = psd;
		elencoProdotti = new ElencoProdotti();
	}

	public int getIndex() {
		return index;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	@Override
	public String toString() {
		return "Utente [index=" + index + ", nome=" + nome + ", cognome=" + cognome + ", user=" + user + ", psd=" + psd
				+ ", elencoProdotti=" + elencoProdotti + "]";
	}

}
