import java.util.Calendar;

public class Veicolo {
	
	private String targa;
	private float prezzo;
	private Calendar annoImmatricolazione;
	
	public Veicolo(String targa, float prezzo, Calendar annoImmatricolazione) {
		super();
		this.targa = targa;
		this.prezzo = prezzo;
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public Veicolo(){
	}
	public String getTarga() {
		return targa;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public Calendar getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public String toString() {
		 return "-TARGA:"+getTarga()+"-PREZZO:"+getPrezzo()+"-ANNO COSTRUZIONE:"+getAnnoImmatricolazione().getTime();
	}
	
}
