package liceocuneo;

import java.util.Calendar;

public class Nave {

	private float lunghezza;
	private float larghezza;
	private Calendar dataArrivo;
	private int ggPermanenza;
	private int posizioneAttracco;
	private String compagnia;
	
	public Nave(float lunghezza, float larghezza, Calendar dataArrivo, int ggPermanenza, int posizioneAttracco,
			String compagnia) {
		super();
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.dataArrivo = dataArrivo;
		this.ggPermanenza = ggPermanenza;
		this.posizioneAttracco = posizioneAttracco;
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

	public Calendar getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Calendar dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public int getGgPermanenza() {
		return ggPermanenza;
	}

	public void setGgPermanenza(int ggPermanenza) {
		this.ggPermanenza = ggPermanenza;
	}

	public int getPosizioneAttracco() {
		return posizioneAttracco;
	}

	public void setPosizioneAttracco(int posizioneAttracco) {
		this.posizioneAttracco = posizioneAttracco;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	
	public String toString() {
		return"lunghezza:"+getLunghezza()+",larghezza:"+getLarghezza();
	}
	
	
	
	
}
