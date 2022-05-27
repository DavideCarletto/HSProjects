package portoNavi;

import java.util.Calendar;

public class Nave {
	
	private float lunghezza;
	private float larghezza;
	private TipoNave tipo;
	private Calendar data;
	private String ora;
	private int permanenza;
	private int nrPosizione;
	private String compagnia;
	private int numPasseggeri;
	
	public Nave() {
	}
	
	public Nave(float lunghezza, float larghezza, TipoNave tipo, int numPasseggeri, Calendar data, String ora, int permanenza,
			int nrPosizione, String compagnia) {
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.tipo = tipo;
		this.numPasseggeri = numPasseggeri;
		this.data = data;
		this.ora = ora;
		this.permanenza = permanenza;
		this.nrPosizione = nrPosizione;
		this.compagnia = compagnia;
	}
	public float getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(float larghezza) {
		this.larghezza = larghezza;
	}
	public TipoNave getTipo() {
		return tipo;
	}
	public void setTipo(TipoNave tipo) {
		this.tipo = tipo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public int getPermanenza() {
		return permanenza;
	}
	public void setPermanenza(int permanenza) {
		this.permanenza = permanenza;
	}
	public int getNrPosizione() {
		return nrPosizione;
	}
	public void setNrPosizione(int nrPosizione) {
		this.nrPosizione = nrPosizione;
	}
	public String getCompagnia() {
		return compagnia;
	}
	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	
	public int getNumPasseggeri() {
		return numPasseggeri;
	}

	public void setNumPasseggeri(int numPasseggeri) {
		this.numPasseggeri = numPasseggeri;
	}

	public String toString() {
		return "Lunghezza: "+getLunghezza()+"\nLarghezza: "+getLarghezza()+"\nTipologia: "+
				getTipo()+"\nNumero dei passeggeri: "+getNumPasseggeri()+"\nData di arrivo: "+
				getData()+"\nOra di arrivo: "+getOra()+"\nDurata della permanenza: "+getPermanenza()+
				"\nNumero posizione: "+getNrPosizione()+"\nNome della compagnia: "+getCompagnia();
	}
	
	

}
