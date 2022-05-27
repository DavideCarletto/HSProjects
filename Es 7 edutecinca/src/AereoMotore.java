
public class AereoMotore extends Aeromobile {

	private double potenzaCv ;

	public AereoMotore(String sigla, double potenzaCv) {
		super(sigla);
		this.potenzaCv = potenzaCv;
	}



	public double getPotenzaCv() {
		return potenzaCv;
	}
	
	
}
