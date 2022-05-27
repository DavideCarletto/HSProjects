package negozioStrumenti;

public class Strumento {
	
		private int codice;
		private String tipo;
		private float prezzo;
		

		public Strumento(int codice, String tipo, float prezzo) {
		this.codice = codice;
		this.tipo = tipo;
		this.prezzo = prezzo;
	}
		
		public int getCodice() {
			return codice;
		}


		public String getTipo() {
			return tipo;
		}


		public float getPrezzo() {
			return prezzo;
		}

		
}
