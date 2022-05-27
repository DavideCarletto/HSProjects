package Robot;

public abstract class Robot {

	private String microProcessore;
	private float memRam;
	private String tipoProcessore;
	private float qtaMem;
	
	
	public Robot(String microProcessore, float memRam, String tipoProcessore, float qtaMem) {
		super();
		this.microProcessore = microProcessore;
		this.memRam = memRam;
		this.tipoProcessore = tipoProcessore;
		this.qtaMem = qtaMem;
	}

	public String getMicroProcessore() {
		return microProcessore;
	}

	public float getMemRam() {
		return memRam;
	}
	
	public String getTipoProcessore() {
		return tipoProcessore;
	}

	public float getQtaMem() {
		return qtaMem;
	}

	public abstract void stampaInformazioniDettaglio();
	public String toString() {
		return "microProcessore: "+getMicroProcessore()+ " memoria Ram: "+getMemRam()+"tipo processore: "+getTipoProcessore()+"memoria: "+getQtaMem();
	}
}
