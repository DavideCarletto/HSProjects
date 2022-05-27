
public class Carburante {
	private float prezzo;
	private TipologiaCarburante tipologia;
	
	public Carburante(int qtaL, float prezzo, TipologiaCarburante tipologia) {
		this.prezzo = prezzo;
		this.tipologia = tipologia;
	}
	public Carburante(float prezzo, TipologiaCarburante tipologia) {
		this.prezzo = prezzo;
		this.tipologia = tipologia;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public TipologiaCarburante getTipologia() {
		return tipologia;
	}
	
	
}
