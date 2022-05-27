package liceocuneo;

import java.util.ArrayList;

public class ElencoProdotti extends ArrayList<Prodotto> {

	public void aggiungiProdotto(Prodotto p) {
		add(p);
	}
	

	public void rimuoviProdotto(Prodotto p) {
		remove(p);
	}
}
