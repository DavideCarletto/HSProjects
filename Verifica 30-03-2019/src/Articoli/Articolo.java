package Articoli;

import java.util.Calendar;

public class Articolo {

	private int identificativo;
	private String titolo;
	private String contenuto;
	private Calendar dataPubblicazione;
	private Autore autore;
	
	
	public Articolo(int identificativo, String titolo, String contenuto, Calendar dataPubblicazione, Autore autore) {
		super();
		this.identificativo = identificativo;
		this.titolo = titolo;
		this.contenuto = contenuto;
		this.dataPubblicazione = dataPubblicazione;
		this.autore = autore;
	}
	
	public int getIdentificativo() {
		return identificativo;
	}
	public String getTitolo() {
		return titolo;
	}
	public String getContenuto() {
		return contenuto;
	}
	public Calendar getDataPubblicazione() {
		return dataPubblicazione;
	}
	public Autore getAutore() {
		return autore;
	}
	
	
	
}
