
public class Prodotto {

	private int  codice;
	private String nome;
	private float prezzoUnitario;
	private int quantita;
	private int qtaMinima;
	
	public Prodotto(int codice, String nome, float prezzoUnitario, int quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
	}
	public int getCodice() {
		return codice;
	}
	
	public String getNome() {
		return nome;
	}
	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public int getQuantita() {
		return quantita;
	}
	public int getQtaMinima() {
		return qtaMinima;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	 
}
