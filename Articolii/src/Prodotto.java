
public class Prodotto extends Object {
	private int codice;
	private String descrizione;
	private float prezzo;
	
	
	public Prodotto(int codice, String descrizione, float prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	public Prodotto() {
		
	}
	
	public int getCodice() {
		return codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public float getPrezzo() {
		return prezzo;
	}
	
}
