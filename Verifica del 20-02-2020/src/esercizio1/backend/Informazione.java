package esercizio1.backend;

public class Informazione {

	private String stato;
	private int popolazione;
	private String anno;
	public Informazione(String stato, int popolazione, String anno) {
		super();
		this.stato = stato;
		this.popolazione = popolazione;
		this.anno = anno;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public int getPopolazione() {
		return popolazione;
	}
	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	public String [] toArrayString() {
		String[] infoS = new String[3];
		infoS[0] = stato;
		infoS[1] = String.valueOf(popolazione);
		infoS[2] = anno;
		
		return infoS;
	}
}
