
public class GestioneNum {
	
	public static void main (String[] args) {
	Razionale n1 = new Razionale();
	
	Tastiera t1 = new Tastiera();
	System.out.println("Immetti il numeratore: ");
	n1.setNumeratore(t1.getNumeroIntero());
	System.out.println("Immetti il denominatore: ");				//il fatto di aver creato la classe tastiera rende lo scanf riutilizzabile.
	n1.setDenominatore(t1.getNumeroIntero());
	
	n1.visualizzaNumero();
	float ris = n1.calcolaFrazione();
	System.out.println("\nIl numero razionale e' "+ris );
	n1.verificaNumeroIntero();
	
	if (n1.verificaNumeroIntero()== true )
		System.out.println("\nIl numero razionale e' intero");
	else 
		System.out.println("\nIl numero razionale non e' intero");
	
	}

}
