
public class Menu {
	private int scelta;
	
	public int getScelta() {
		return scelta;
	}
	public void setScelta(int scelta) {
		this.scelta = scelta;
	}
	public static void main (String[]args) {
		
		Menu m1 = new Menu();
		ParolaIta p1 = new ParolaIta();
		Tastiera t1 = new Tastiera();
		System.out.println("Menu:\n1- visualizza la parola.\n2- inverti la parola.\n3- verifica se la parola e' palindroma\n4- esci");
		System.out.println("\nInserisci la parola: ");
		p1.setParola(t1.getTesto());
		
		do {
		System.out.println("Scegli un numero:");
		m1.scelta = t1.getNumeroIntero();
		
			switch(m1.scelta) {
			case 1: 
					p1.visualizza();
					break;
			case 2:
					System.out.println("la parola invertita e'"+p1.inverti());
					break;
			case 3: 
					if (p1.isPalindroma()==true)
						System.out.println("La parola e' un palindroma");
					else
						System.out.println("La parola non e' un palindroma");
						break;
			case 4: 
					System.out.println("Arrivederci");
					break;
			}
			
		}while(m1.scelta != 4);
	}
}

