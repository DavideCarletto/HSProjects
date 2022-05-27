import java.util.Calendar;

public class Autore {

	private int codice;
	private String nome;
	private String cognome;
	private Calendar dataNascita;
	private Libro[] elencoLibri;

	
	
	public Autore(int codice, String nome, String cognome, Calendar dataNascita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.elencoLibri = elencoLibri;

	}
	public int getCodice() {
		return codice;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public Calendar getDataNascita() {
		return dataNascita;
	}
	
	
}
