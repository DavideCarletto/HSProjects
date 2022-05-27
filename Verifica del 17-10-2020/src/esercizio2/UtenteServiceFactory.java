package esercizio2;

public class UtenteServiceFactory {

	public static UtenteService utenteServiceFactory() {
		UtenteService serv = (UtenteService) new UtenteServiceimpl();
		return serv;
	}
}
