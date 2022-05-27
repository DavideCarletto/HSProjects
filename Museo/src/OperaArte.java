
public abstract class OperaArte {

	private String nome;
	private Artista elencoArtisti[];
	private Museo m;
	private int peso;
	private int altezza;
	private int larghezza;
	private int profondita;
	
	
	
	public abstract void calcolaIngombro();
	public abstract int getPeso();
	
	public OperaArte(String nome, int peso, int altezza, int larghezza, int profondita) {
		super();
		this.nome = nome;
		this.m = m;
		this.peso = peso;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.profondita = profondita;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Artista[] getElencoArtisti() {
		return elencoArtisti;
	}



	public int getPesoBase() {
		return peso;
	}
	public int getAltezza() {
		return altezza;
	}
	public int getLarghezza() {
		return larghezza;
	}
	public int getProfondita() {
		return profondita;
	}


	
}
