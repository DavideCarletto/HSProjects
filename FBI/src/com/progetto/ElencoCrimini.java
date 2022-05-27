package com.progetto;

import java.util.ArrayList;

public class ElencoCrimini extends ArrayList<Crimine> {

	private void aggiungiCrimine(Crimine crimine) {
		add(crimine);
	}
	
	private void rimuoviCrimine(Crimine crimine) {
		remove(crimine);
	}
}
