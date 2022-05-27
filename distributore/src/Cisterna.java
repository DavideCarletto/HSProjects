
public class Cisterna {

	private Carburante carburante;
	private  int litriTot;
	
	
	public Cisterna(Carburante carburante, int litriTot) {
		super();
		this.carburante = carburante;
		this.litriTot = litriTot;
		
	}

	public Carburante carburante() {
		return carburante;
	}

	public int getLitriTot() {
		return litriTot;
	}
	
}
