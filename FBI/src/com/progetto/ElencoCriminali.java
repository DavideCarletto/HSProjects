package com.progetto;

import java.util.ArrayList;

public class ElencoCriminali extends ArrayList<Criminale> {

	private void aggiungiCrimine(Criminale criminale) {
		add(criminale);
	}
	
	private void rimuoviCrimine(Criminale criminale) {
		remove(criminale);
	}
}
