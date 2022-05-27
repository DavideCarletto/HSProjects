import java.util.Scanner;
import java.util.TreeMap;

public class GestioneContatti {

	private TreeMap<String, Contatto> elencoContatti;
	private static Scanner s;

	public GestioneContatti() {
		elencoContatti = new TreeMap<>();
		s = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			Contatto contatto = new Contatto("Davide" + (i + 1), "Carletto" + (i + 1), "carlettodavide@gmail.com" + (i + 1));
			elencoContatti.put(contatto.getMail(), contatto);
		}
	}

	public void ricerca(String email) {
		Contatto contatto = elencoContatti.get(email);
		System.out.println("Nome: " + contatto.getNome() + ", Cognome" + contatto.getNome());
	}

	public static void main(String[] args) {
		GestioneContatti g = new GestioneContatti();
		String email  = null;
		do {
			System.out.println("Entra l'email del contatto: ");
			email = s.next();
			g.ricerca(email);
		} while(!email.equals(String.valueOf(0)));
	}
}
