package Robot;

import java.util.Calendar;

public class Ordine {

	private Robot elencoRobot[];
	private Cliente cliente;
	private int indirizzo;
	private int numOrdine;
	private Calendar dataOrdine;
	public Ordine(Robot[] elencoRobot, Cliente cliente, int indirizzo, int numOrdine, Calendar dataOrdine) {
		super();
		this.elencoRobot = elencoRobot;
		this.cliente = cliente;
		this.indirizzo = indirizzo;
		this.numOrdine = numOrdine;
		this.dataOrdine = dataOrdine;
	}
	public Robot[] getElencoRobot() {
		return elencoRobot;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public int getIndirizzo() {
		return indirizzo;
	}
	public int getNumOrdine() {
		return numOrdine;
	}
	public Calendar getDataOrdine() {
		return dataOrdine;
	}
	
	
}
