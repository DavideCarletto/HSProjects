package programma;

public class Stella extends OggettoExtrasolare {

	private float temperaturaGradi;
	private Colore colore;
	
	public Stella(String nome, float magnitudine, float distanzaTerra, float temperaturaGradi, Colore colore) {
		super(nome, magnitudine, distanzaTerra);
		this.temperaturaGradi = temperaturaGradi;
		this.colore = colore;
	}
	public float getTemperaturaGradi() {
		return temperaturaGradi;
	}
	public Colore getColore() {
		return colore;
	}
	
	public String toString() {
		return super.toString()+" TEMPERATURA: "+getTemperaturaGradi()+" °C COLORE:"+getColore();
	}
	
}
