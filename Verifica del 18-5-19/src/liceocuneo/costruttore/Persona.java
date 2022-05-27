package liceocuneo.costruttore;

import java.util.Calendar;

public class Persona {

	private String nome;
	private String cognome;
	private Calendar dataNascita;
	
	
	public Persona(String nome) {
		this.nome = nome;
	}																	//overload
	
	public Persona (String cognome, Calendar dataNascita) {
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
