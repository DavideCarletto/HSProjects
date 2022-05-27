import java.util.Calendar;

public class Motoveicolo extends Veicolo{
	
	private Categoria categoria;

	public Motoveicolo(String targa, float prezzo, Calendar annoImmatricolazione, Categoria categoria) {
		super(targa, prezzo, annoImmatricolazione);
		// TODO Auto-generated constructor stub
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return super.toString()+" -CATEGORIA:"+getCategoria();
	}
	
	 
}
