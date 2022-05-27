package liceocuneo.backend;

import java.sql.Date;

public class Info {

	private Date data;
	private int totPositivi;
	private int nuoviPositivi;
	private int numTamponi;
	
	
	public Info(Date data, int totPositivi, int nuoviPositivi, int numTamponi) {
		super();
		this.data = data;
		this.totPositivi = totPositivi;
		this.nuoviPositivi = nuoviPositivi;
		this.numTamponi = numTamponi;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
	
	@Override
	public String toString() {
		return "Info [data=" + data + ", totPositivi=" + totPositivi + ", nuoviPositivi=" + nuoviPositivi
				+ ", numTamponi=" + numTamponi + "]";
	}
	
	
	
}
