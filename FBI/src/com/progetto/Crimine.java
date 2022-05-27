package com.progetto;

import java.sql.Date;

public class Crimine {

	private int id;
	private String nome;
	private String descrizione;
	private Date dataCrimine;

	public Crimine() {
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataCrimine() {
		return dataCrimine;
	}

	public void setDataCrimine(Date dataCrimine) {
		this.dataCrimine = dataCrimine;
	}

	
	@Override
	public String toString() {
		return "Crimine [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", dataCrimine=" + dataCrimine
				+ "]";
	}

	public String[] toArrayString() {
		String[] crimineS = new String[3];
		crimineS[0] = nome;
		crimineS[1] = descrizione;
		String dataNascitaS = dataCrimine.toString();
		crimineS[2] = dataNascitaS;
		
		return crimineS;
	}
}
