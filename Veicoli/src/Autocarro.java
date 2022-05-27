import java.util.Calendar;

public class Autocarro extends Veicolo{
	
	private int qtaMax;

	public Autocarro(String targa, float prezzo, Calendar annoImmatricolazione, int qtaMax) {
		super(targa, prezzo, annoImmatricolazione);
		// TODO Auto-generated constructor stub
		this.qtaMax = qtaMax;
	}

	public int getQtaMax() {
		return qtaMax;
	}
	public String toString() {
		return super.toString()+" -QUANTITA MASSIMA:"+getQtaMax();
	}
	
}
