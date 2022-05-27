package liceocuneo.figure;
import java.util.regex.Pattern;

public class Linea extends FiguraGeometrica{

	private Punto p1;

	public Linea(Punto p, Punto p1) {
		super(p);
		this.p1 = p1;

	}

	public Punto getP1() {
		return p1;
	}

	public String toString(){
		return super.toString()+" PUNTO 2:("+p1.getX()+","+p1.getY()+") ";
	}
}
