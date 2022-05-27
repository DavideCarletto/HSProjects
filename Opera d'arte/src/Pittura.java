
public class Pittura extends OperaArte {

public Pittura(String nome, float altezza, float larghezza, int peso) {
		super(nome, altezza, larghezza,peso);  //,profondità standard //
	}


public  void ingombro() {
		float ingombro = getAltezza()*getLarghezza()*10;
		System.out.println("La pittura selezionata ha un volume di "+ingombro+" cm");
	}
	public  int getPeso() {
		
		return getPesoBase();
	}
	
	public String toString() {
		return ""+getNome();
	}
}
