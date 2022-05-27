package segmenti;

public class Segmento {
		
		private Punto pPrecedente;
		public Punto getpPrecedente() {
			return pPrecedente;
		}

		public void setpPrecedente(Punto pPrecedente) {
			this.pPrecedente = pPrecedente;
		}

		public Punto getpCorrente() {
			return pCorrente;
		}

		public void setpCorrente(Punto pCorrente) {
			this.pCorrente = pCorrente;
		}

		private Punto pCorrente;
		
		public Segmento(Punto pPrecedente, Punto pCorrente) {
			super();
			this.pPrecedente = pPrecedente;
			this.pCorrente = pCorrente;
		}
}
