package liceocuneo.comune;

public class Comune {

	private String codice;
	private String denominazioneStraniera;
	private String denominazioneItaliano;
	
	 public Comune() {
		// TODO Auto-generated constructor stub
	}
	public Comune(String codice, String denominazioneStraniera, String denominazioneItaliano) {
		super();
		this.codice = codice;
		this.denominazioneStraniera = denominazioneStraniera;
		this.denominazioneItaliano = denominazioneItaliano;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDenominazioneStraniera() {
		return denominazioneStraniera;
	}
	public void setDenominazioneStraniera(String denominazioneStraniera) {
		this.denominazioneStraniera = denominazioneStraniera;
	}
	public String getDenominazioneItaliano() {
		return denominazioneItaliano;
	}
	public void setDenominazioneItaliano(String denominazioneItaliano) {
		this.denominazioneItaliano = denominazioneItaliano;
	}
	@Override
	public String toString() {
		return "Comune [codice=" + codice + ", denominazioneStraniera=" + denominazioneStraniera
				+ ", denominazioneItaliano=" + denominazioneItaliano + "]";
	}
	
	
	
	
}
