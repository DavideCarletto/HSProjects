
public class Scultura extends OperaArte {

	private float  profondita;

	public Scultura(String nome, float altezza, float larghezza, float profondita,int peso) {
		super(nome, altezza, larghezza, peso);
		this.profondita = profondita;
	}

	public float getProfondita() {
		return profondita;
	}

public  void ingombro() {
	float ingombro = getAltezza()*getLarghezza()*profondita;
	System.out.println("La scultura selezionata ha un volume di "+ingombro+" cm");
	}
	public  int getPeso() {
		return getPesoBase()+10;
	}
	public String toString() {
		return ""+getNome();
	}
	
}
