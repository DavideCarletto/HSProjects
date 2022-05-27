package programma;

public class OggettoSemplice extends OggettoExtrasolare {

	private float diametro;

	public OggettoSemplice(String nome, float magnitudine, float distanzaTerra, float diametro) {
		super(nome, magnitudine, distanzaTerra);
		this.diametro = diametro;
	}

	public float getDiametro() {
		return diametro;
	}
	public String toString() {
		return super.toString()+" DIAMETRO: "+getDiametro()+" Km";
	}
}
