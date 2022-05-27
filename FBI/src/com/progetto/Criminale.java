package com.progetto;

import java.sql.Date;
import java.util.Calendar;

public class Criminale {

	private int id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String fotoByte;
	private int numCrimini;
	

	public int getNumCrimini() {
		return numCrimini;
	}

	public void setNumCrimini(int numCrimini) {
		this.numCrimini = numCrimini;
	}

	public String getFotoByte() {
		return fotoByte;
	}

	public void setFotoByte(String fotoByte) {
		this.fotoByte = fotoByte;
	}

	public Criminale() {
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	
	
	@Override
	public String toString() {
		return "Criminale [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ "]";
	}
	
	public String[] toArrayString() {
		String[] criminaleS = new String[3];
		criminaleS[0] = nome;
		criminaleS[1] = cognome;
		String dataNascitaS = dataNascita.toString();
		criminaleS[2] = dataNascitaS;
		
		return criminaleS;
	}
	
}
