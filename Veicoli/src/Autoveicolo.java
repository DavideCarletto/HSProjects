import java.util.Calendar;

public class Autoveicolo extends Veicolo{

	private int cilindrata;
	private int numPorte;
	
	public Autoveicolo(String targa, float prezzo, Calendar annoImmatricolazione, int cilindrata, int numPorte) {
		super(targa, prezzo, annoImmatricolazione);
		this.cilindrata = cilindrata;
		this.numPorte = numPorte;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public int getNumPorte() {
		return numPorte;
	}
	public String toString() {
		return super.toString()+" -CILINDRATA: +Cilindrata() -NUMERO PORTE:" +getNumPorte();
	}
	
	
}
