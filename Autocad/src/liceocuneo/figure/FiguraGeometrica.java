package liceocuneo.figure;

public abstract class  FiguraGeometrica {
	
	private Punto p;

	public FiguraGeometrica(Punto p) {
			this.p = p;
	}

	public Punto getP() {
		return p;
	}
	
	public String toString(){
		return "PUNTO:("+p.getX()+","+p.getY()+")";
	}
}
