import java.util.Calendar;

public class Cliente {
	
	private String nome;
	private String cognome;
	private Calendar dataNascita;
	
	public Cliente(String nome, String cognome, Calendar dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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
