package Robot;

public class TipoC extends Robot{

	private Materiale materiale;

	

	public TipoC(String microProcessore, float memRam, String tipoProcessore, float qtaMem, Materiale materiale) {
		super(microProcessore, memRam, tipoProcessore, qtaMem);
		this.materiale = materiale;
	}

	public Materiale getMateriale() {
		return materiale;
	}
	
public void stampaInformazioniDettaglio() {
		System.out.println(super.toString()+" materale: "+getMateriale());
	}
}
