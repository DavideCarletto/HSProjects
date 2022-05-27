
public class Scultura extends OperaArte{

	public Scultura(String nome, int peso, int altezza, int larghezza, int profondita) {
		super(nome, peso, altezza, larghezza, profondita);
		
	}

	
	public void calcolaIngombro() {
		
	}
	public int getPeso() {
		return 0;
	}
	
	public String toString() {
		return ""+getNome();
	}
	
}
