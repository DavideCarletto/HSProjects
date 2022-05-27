package campeggio;

public class Campeggio {
	
	private String nome;
	private int indirizzo;
	private double latitudine;
	private double longitudine;
	
	public Campeggio(String nome, int indirizzo, double latitudine, double longitudine) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	public Campeggio() {
		
	}

	public String getNome() {
		return nome;
	}

	public int getIndirizzo() {
		return indirizzo;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public double getLongitudine() {
		return longitudine;
	}
	
	
}
