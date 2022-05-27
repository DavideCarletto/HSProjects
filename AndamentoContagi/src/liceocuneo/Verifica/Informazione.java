package liceocuneo.Verifica;

import java.sql.Date;

public class Informazione {

	private int totPositivi;
	private int nuoviPositivi;
	private int numTamponi;
	
	
	public Informazione(Date data, int totPositivi, int nuoviPositivi, int numTamponi) {
		super();
		this.totPositivi = totPositivi;
		this.nuoviPositivi = nuoviPositivi;
		this.numTamponi = numTamponi;
	}
	public int getTotPositivi() {
		return totPositivi;
	}
	public void setTotPositivi(int totPositivi) {
		this.totPositivi = totPositivi;
	}
	public int getNuoviPositivi() {
		return nuoviPositivi;
	}
	public void setNuoviPositivi(int nuoviPositivi) {
		this.nuoviPositivi = nuoviPositivi;
	}
	public int getNumTamponi() {
		return numTamponi;
	}
	public void setNumTamponi(int numTamponi) {
		this.numTamponi = numTamponi;
	}

}
