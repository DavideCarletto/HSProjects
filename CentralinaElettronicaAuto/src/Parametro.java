
public class Parametro {

	private int cod;
	private String descrizione;
	private int valoreInt;
	private Categoria categoria;
	
	public Parametro(int cod, String descrizione, int valoreInt, Categoria categoria) {
		super();
		this.cod = cod;
		this.descrizione = descrizione;
		this.valoreInt = valoreInt;
		this.categoria = categoria;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getValoreInt() {
		return valoreInt;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public String toString() {
		return ""+getCod()+", "+getDescrizione()+", "+getValoreInt()+", "+getCategoria();
	}
	
}
