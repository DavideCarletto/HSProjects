package programma;

public class Esopianeta extends OggettoExtrasolare{

	private int nSatelliti;

	public Esopianeta(String nome, float magnitudine, float distanzaTerra, int nSatelliti) {
		super(nome, magnitudine, distanzaTerra);
		this.nSatelliti = nSatelliti;
	}

	public int getnSatelliti() {
		return nSatelliti;
	}
	
	public String toString() {
		return super.toString()+" NUMERO SATELLITI: "+getnSatelliti();
	}
	
	
}
