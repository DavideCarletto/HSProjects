
import java.io.BufferedReader;
import java.io.InputStreamReader; //come l'include

public class GestioneNumero {
	public static void main(String[] args) {
		NumeroRazionale n1 = new NumeroRazionale();
		n1.setNumeratore(5);
		n1.setDenominatore(7);
		System.out.println("il numeratore e': "+n1.getNumeratore());
		
		Persona p1 = new Persona();	//* è come scrivere questa cosa
		String s = "ABC";
		p1.setCodfiscale(s);
	
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
	}
}
