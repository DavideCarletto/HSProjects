package liceocuneo.figure;

public class Cerchio extends FiguraChiusa {

	public static final float PIGRECO = 3.14f;
	private int raggio;

	public Cerchio(Punto p,int raggio) {
		super(p);
		this.raggio = raggio;
	}

	public int getRaggio() {
		return raggio;
	}

	public int calcolaArea() {
		
		return (int) (raggio*raggio*PIGRECO);
	}
	
	public int calcolaPerimetro() {
		
		return (int) (2*PIGRECO*raggio);
	}

	public String toString() {
		return super.toString()+" RAGGIO: "+getRaggio();
	}
}
