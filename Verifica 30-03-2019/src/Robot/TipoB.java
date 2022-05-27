package Robot;

public class TipoB extends Robot{

	private int nPuntiSaldatura;

	public TipoB(String microProcessore, float memRam, String tipoProcessore, float qtaMem, int nPuntiSaldatura) {
		super(microProcessore, memRam, tipoProcessore, qtaMem);
		this.nPuntiSaldatura = nPuntiSaldatura;
	}

	public int getnPuntiSaldatura() {
		return nPuntiSaldatura;
	}
public void stampaInformazioniDettaglio() {
		
	System.out.println(super.toString()+""+getnPuntiSaldatura());
	}
}
