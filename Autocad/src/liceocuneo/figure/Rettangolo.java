package liceocuneo.figure;
public class Rettangolo extends FiguraChiusa{

	private int base;
	private int altezza;
	
	
	public Rettangolo(Punto p, int base, int altezza) {
		super(p);
		this.base = base;
		this.altezza = altezza;
	}

	public int calcolaArea() {
		return base*altezza;
	}
	
	public int calcolaPerimetro() {
		return (base+altezza)*2;
	}
	

	public int getBase() {
		return base;
	}

	public int getAltezza() {
		return altezza;
	}
	public String toString() {
		return super.toString()+" BASE: "+getBase()+" ALTEZZA: "+getAltezza();
	}
	
}
