package liceocuneo.esercizio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Gestione {

	private TreeMap<Integer, Prodotto> elencoProdotti;

	public Gestione() {
		elencoProdotti = new TreeMap<Integer, Prodotto>();
	}

	public void caricaLista() {
		File f = new File("C:\\Users\\Davide Carletto\\Documents\\scuola 2.0\\Info\\Java\\prodotti2.csv");
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buf = new BufferedReader(reader);
		String line = null;

		try {
			while ((line = buf.readLine()) != null) {
				String[] prodottoS = line.split(";");
				int codice = Integer.parseInt(prodottoS[0]);
				String descrizione = prodottoS[1];
				float prezzo = Float.parseFloat(prodottoS[2]);

				Prodotto p = new Prodotto(codice, descrizione, prezzo);
				elencoProdotti.put(codice, p);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cercaPerCodice(int codice) {
		Prodotto p = elencoProdotti.get(codice);
		System.out.println("Descrizione:" + p.getDescrizione() + ",Prezzo:" + p.getPrezzo());
	}

	public static void main(String[] args) {
		Gestione g = new Gestione();
		g.caricaLista();
		g.cercaPerCodice(12);

	}

}
