package esercizio1.backend;

import java.io.File;

public interface PopolazioneService {

	public ElencoInformazioni leggiDati(File f);
	public void caricaSuDb(ElencoInformazioni elenco);
	public ElencoInformazioni leggiDatiOrdinati(boolean decrescente);
}
