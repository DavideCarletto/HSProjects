import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProdottoAlimentare extends Prodotto {

	private Calendar dataScad;

	public ProdottoAlimentare(int codice, String descrizione, float prezzo,Calendar dataScad) {
		super(codice, descrizione, prezzo);
		this.dataScad = dataScad;
		// TODO Auto-generated constructor stub
	}
	

	public Calendar getDataScad() {
		return dataScad;
	}
	public String toString() {
		String ris = "";
		ris += getCodice();
		ris += " ";
		ris += getPrezzo();
		ris += " ";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		ris += sdf.format(dataScad.getTime());
		ris += " ";
		return ris;
	}
	
	
}
