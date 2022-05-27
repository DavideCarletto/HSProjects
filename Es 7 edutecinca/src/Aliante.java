
public class Aliante extends Aeromobile {

	private int numeroEff ;

	public Aliante(String sigla, int numeroEff) {
		super(sigla);
		this.numeroEff = numeroEff;
	}

	public int getNumeroEff() {
		return numeroEff;
	}
	
	
}
