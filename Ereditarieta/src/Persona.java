import java.util.Calendar;

public class Persona extends Object{
	
	private String cognome;
	private String nome;
	private Calendar dataNascita;
	
	public Persona() {
		
	}
	
	public Persona(String cognome, String nome) {
		
		setCognome(cognome);
		setNome(nome);
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public Calendar getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Calendar dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	
}
