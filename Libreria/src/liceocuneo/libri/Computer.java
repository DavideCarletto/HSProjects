package liceocuneo.libri;

public class Computer {
		
		private int numero;
		private float frequenzaGh;
		private float ram;
		
		public Computer(int numero, float frequenzaGh, float ram) {
			this.numero = numero;
			this.frequenzaGh = frequenzaGh;
			this.ram = ram;
		}
		
		public int getNumero() {
			return numero;
		}

		public float getFrequenzaGh() {
			return frequenzaGh;
		}

		public float getRam() {
			return ram;
		}
}
