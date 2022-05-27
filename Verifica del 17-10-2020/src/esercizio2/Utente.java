package esercizio2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utente {

	private String nome;
	private String cognome;
	private Calendar dataRegistrazione;
	private String username;

	public Utente(String nome, String cognome, Calendar dataRegistrazione, String username) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataRegistrazione = dataRegistrazione;
		this.username = username;
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

	public Calendar getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Calendar dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date d = dataRegistrazione.getTime();
		String dataRegistrazioneS = sdf.format(d);
		
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataRegistrazione=" + dataRegistrazioneS
				+ ", username=" + username + "]";
	}

}
