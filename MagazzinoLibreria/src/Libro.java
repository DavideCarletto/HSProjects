
public class Libro {

	private int codice;
	private String titolo;
	private Genere genere; 
	private float prezzo;
	private Autore[] elencoAutori;
	private int index;
	
	public Libro(int codice, String titolo, Genere genere, float prezzo) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.genere = genere;
		this.prezzo = prezzo;
		elencoAutori = new Autore[100];
	}
	
	public void addAutore(Autore autore) {
		elencoAutori[index++] = autore;
	}
	public String toString() {
		return"Codice: "+getCodice()+", titolo: '"+getTitolo()+"', Genere: "+getGenere()+", Prezzo: "+getPrezzo()+" Euro.";
	}
	public int getCodice() {
		return codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public Genere getGenere() {
		return genere;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public Autore[] getElencoAutori() {
		return elencoAutori;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
