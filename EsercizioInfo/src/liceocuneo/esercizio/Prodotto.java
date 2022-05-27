package liceocuneo.esercizio;

public class Prodotto {

	private int codice;
	private String descrizione;
	private float prezzo;

	public Prodotto(int codice, String descrizione, float prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

}
