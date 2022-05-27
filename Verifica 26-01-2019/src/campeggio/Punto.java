package campeggio;

public class Punto {
	private double latitudine;
	private double longitudine;
	
	public Punto(double latitudine, double longitudine) {
		super();
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	
}
