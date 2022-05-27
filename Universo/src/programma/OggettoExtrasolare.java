package programma;

public class OggettoExtrasolare {

	private String nome;
	private float magnitudine;
	private float distanzaTerra;
	
	public OggettoExtrasolare(String nome, float magnitudine, float distanzaTerra) {
		super();
		this.nome = nome;
		this.magnitudine = magnitudine;
		this.distanzaTerra = distanzaTerra;
	}

	public String getNome() {
		return nome;
	}

	public float getMagnitudine() {
		return magnitudine;
	}

	public float getDistanzaTerra() {
		return distanzaTerra;
	}
	public String toString() {
		return "NOME: "+getNome()+" MAGNITUDINE: "+getMagnitudine()+" DISTANZA DALLA TERRA:"+getDistanzaTerra()+" km";
	}
	
}
