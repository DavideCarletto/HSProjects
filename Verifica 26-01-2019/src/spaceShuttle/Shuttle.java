package spaceShuttle;

public class Shuttle {
	private int codice;
	private int  annoCostruzione;
	
	public Shuttle(int codice, int annoCostruzione) {
		super();
		this.codice = codice;
		this.annoCostruzione = annoCostruzione;
	}
	public int getCodice() {
		return codice;
	}
	public int getAnnoCostruzione() {
		return annoCostruzione;
	}
	
}
