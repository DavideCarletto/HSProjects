package liceocuneo.esercizio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Gestione {

	private TreeMap<Integer, Prodotto> elencoProdotti;
	public static final String percorso = "C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\Verifica del 05-12-2020\\src\\liceocuneo\\esercizio1\\Prodotto.csv";

	public Gestione() {
		elencoProdotti = new TreeMap<Integer, Prodotto>();
	}

	public void leggiCsv() {
		File f = new File(percorso);

		FileReader fr = null;
		BufferedReader br = null;
		String line = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			do {

				line = br.readLine();
				if(line != null) {
					String[] prodottoS = line.split(";");
					int codice = Integer.parseInt(prodottoS[0]);
					String descrizione = prodottoS[1];
					float prezzo = Float.parseFloat(prodottoS[2]);
					
					Prodotto p = new Prodotto(codice, descrizione, prezzo);
					elencoProdotti.put(codice, p);
				}
			} while (line != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void ricercaPerCodice(int codice) {
		System.out.println(elencoProdotti.get(codice).toString());
	}

	public static void main(String[] args) {
		Gestione g = new Gestione();
		g.leggiCsv();
		g.ricercaPerCodice(789);
	}
}
