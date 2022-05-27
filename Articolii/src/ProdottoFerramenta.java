

public class ProdottoFerramenta extends Prodotto{

	private TipoProdottoFerramenta tipo;


	public ProdottoFerramenta(int codice, String descrizione,float prezzo,TipoProdottoFerramenta tipo) {
		super(codice,descrizione,prezzo);
		this.tipo = tipo;
	}

	public TipoProdottoFerramenta getTipo() {
		return tipo;
	}
	public String toString() {
		String ris = "";
		ris += getCodice();
		ris += " ";
		ris += getPrezzo();
		ris += " ";
		ris += getTipo();
		ris += " ";
		return ris;
	}
}
