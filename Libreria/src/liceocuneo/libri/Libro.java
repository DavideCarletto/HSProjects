package liceocuneo.libri;

public class Libro {
		
	private String codice;
	private String titolo;
	private float prezzo;
	private int qta;
		
		public Libro(String codice, String titolo, float prezzo, int qta) {
			this.codice = codice;
			this.titolo = titolo;
			this.prezzo = prezzo;
			this.qta = qta;
		}
		public String getCodice() {
			return codice;
		}

		public String getTitolo() {
			return titolo;
		}

		public float getPrezzo() {
			return prezzo;
		}

		public int getQta() {
			return qta;
		}

}
