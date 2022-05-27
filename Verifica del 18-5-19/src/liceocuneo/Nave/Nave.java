package liceocuneo.Nave;

import java.sql.Time;
import java.util.Calendar;

public class Nave {

	private float lunghezza;
	private float larghezza;
	private Tipo tipo;
	private Calendar dataArrivo;
	private int oraArrivo;
	private int tempoPermanenzaOre;
	private int numeroPosAttr;
	private String compagnia;
	private int numPasseggeri;
	private Calendar dataPartenza;
	private int oraPartenza;
	
	
	public Nave(float lunghezza, float larghezza, Tipo tipo, Calendar dataArrivo, int oraArrivo, int tempoPermanenzaOre,
			int numeroPosAttr, String compagnia, int numPasseggeri) {
		super();
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.tipo = tipo;
		this.dataArrivo = dataArrivo;
		this.oraArrivo = oraArrivo;
		this.tempoPermanenzaOre = tempoPermanenzaOre;
		this.numeroPosAttr = numeroPosAttr;
		this.compagnia = compagnia;
		this.numPasseggeri = numPasseggeri;
	}
	
	public Calendar getDataPartenza() {
		return dataPartenza;
	}

	public int getOraPartenza() {
		return oraPartenza;
	}

	public float getLunghezza() {
		return lunghezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public Calendar getDataArrivo() {
		return dataArrivo;
	}
	public int getTempoPermanenzaOre() {
		return tempoPermanenzaOre;
	}
	public int getNumeroPosAttr() {
		return numeroPosAttr;
	}
	public String getCompagnia() {
		return compagnia;
	}
	public int getNumPasseggeri() {
		return numPasseggeri;
	}
	
	
	public int getOraArrivo() {
		return oraArrivo;
	}
	
	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}
	public void setLarghezza(float larghezza) {
		this.larghezza = larghezza;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public void setDataArrivo(Calendar dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public void setOraArrivo(int oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	public void setTempoPermanenzaOre(int tempoPermanenzaOre) {
		this.tempoPermanenzaOre = tempoPermanenzaOre;
	}
	public void setNumeroPosAttr(int numeroPosAttr) {
		this.numeroPosAttr = numeroPosAttr;
	}
	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	public void setNumPasseggeri(int numPasseggeri) {
		this.numPasseggeri = numPasseggeri;
	}
	public void setDataPartenza(Calendar dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public void setOraPartenza(int oraPartenza) {
		this.oraPartenza = oraPartenza;
	}
	public String toString() {
		return "LUNGHEZZA:"+getLunghezza()+", LARGHEZZA:"+getLarghezza()+", TIPO:"+getTipo()+", DATA ARRIVO:"+getDataArrivo()+""+getTempoPermanenzaOre()+", NUMERO POSIZIONE:"+getNumeroPosAttr()+", COMPAGNIA:"+getCompagnia()+", NUMERO PASSEGGERI:"+getNumPasseggeri();
		}
	
	
}
