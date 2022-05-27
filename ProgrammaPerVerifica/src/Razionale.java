
public class Razionale {
	private int numeratore;
	private int denominatore;
	
	public int getNumeratore() {
		return numeratore;
	}
	public void setNumeratore(int numeratore) {
		this.numeratore = numeratore;
	}
	
	public int getDenominatore() {
		return denominatore;
	}
	public void setDenominatore(int denominatore) {
		this.denominatore = denominatore;
	}
	
	void visualizzaNumero() {
		 System.out.println("il numero razionale e' :"+numeratore+"/"+denominatore);
	}
	
	float calcolaFrazione() {
		return (float)numeratore / (float)denominatore;
	}
	boolean verificaNumeroIntero() {
		boolean intero;
		if ((numeratore)%(denominatore)==0) 
			intero = true;
		else 
			intero = false;
		
		return intero;
		
	}
	
}
