package liceocuneo;

import java.util.Calendar;

public class NavePasseggeri extends Nave {

	private int nPasseggeri;

	public NavePasseggeri(float lunghezza, float larghezza, Calendar dataArrivo, int ggPermanenza,
			int posizioneAttracco, String compagnia, int nPasseggeri) {
		super(lunghezza, larghezza, dataArrivo, ggPermanenza, posizioneAttracco, compagnia);
		this.nPasseggeri = nPasseggeri;
	}

	public int getnPasseggeri() {
		return nPasseggeri;
	}

	public void setnPasseggeri(int nPasseggeri) {
		this.nPasseggeri = nPasseggeri;
	}
	
	

	
	
}
