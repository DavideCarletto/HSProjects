
public abstract class OperaArte {

	private  String nome;
	private float altezza;
	private float larghezza;
	private Artista elencoArtisti[];
	private int peso;
	
	
	
	abstract void ingombro();
	abstract int getPeso();
	
	
	public OperaArte(String nome, float altezza, float larghezza, int peso) {
		super();
		this.nome = nome;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.peso=peso;
	}
	public OperaArte() {
		
	}
	public String getNome() {
		return nome;
	}
	
	
	public float getAltezza() {
		return altezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	
	public int getPesoBase() {
		return peso;
	}
	
	
	
}
