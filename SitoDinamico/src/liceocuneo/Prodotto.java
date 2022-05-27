package liceocuneo;

public class Prodotto {

	private int index;
	private String descrizione;
	private int qta;
	private float prezzo;

	
	public Prodotto(int index, String descrizione, int qta, float prezzo) {
		super();
		this.index = index;
		this.descrizione = descrizione;
		this.qta = qta;
		this.prezzo = prezzo;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}
