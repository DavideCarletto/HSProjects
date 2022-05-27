
public abstract class Aeromobile implements CMP{

		private String sigla;
		
		public Aeromobile(String sigla) {
			super();
			this.sigla = sigla;
		}

		public String getSigla() {
			return sigla;
		}
		
		public boolean verificaPrestazione (Aeromobile ar) {
			boolean valore = true;
			
			return valore;
		}
		
}
