package centralinaMeteorologica;

public class Evento {
	private float numDecimale;
	private TipologiaEvento tipologia;
	private int numeroProgressivo;
	
	public Evento(float numDecimale, TipologiaEvento tipologia,int numeroProgressivo) {
		super();
		this.numDecimale = numDecimale;
		this.tipologia = tipologia;
		this.numeroProgressivo = numeroProgressivo;
	}
	public Evento() {
		
	}
	
	public int getNumeroProgressivo() {
		return numeroProgressivo;
	}

	public float getNumDecimale() {
		return numDecimale;
	}
	public TipologiaEvento getTipologia() {
		return tipologia;
	}
	
	
}
