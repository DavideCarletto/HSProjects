package Robot;

public class TipoA extends Robot{

	
	private float spessoreTaglioMm;
	private float precisioneMm;
	
	

	public TipoA(String microProcessore, float memRam, String tipoProcessore, float qtaMem, float spessoreTaglioMm,
			float precisioneMm) {
		super(microProcessore, memRam, tipoProcessore, qtaMem);
		this.spessoreTaglioMm = spessoreTaglioMm;
		this.precisioneMm = precisioneMm;
	}


	public float getSpessoreTaglioMm() {
		return spessoreTaglioMm;
	}

	public float getPrecisioneMm() {
		return precisioneMm;
	}
	public void stampaInformazioniDettaglio() {
		System.out.println(super.toString()+"spessore taglio: "+getSpessoreTaglioMm()+"precisione mm: "+getPrecisioneMm());
	}
	
}
