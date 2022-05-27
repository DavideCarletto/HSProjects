package liceocuneo.forum;

public class Forum {
	private static final int NUM_MAX_TOPIC = 100;
	private Topic[] elencoTopic = null;
	private Tastiera t = new Tastiera();
	private int index = 0;
	
	public Forum() {
		elencoTopic = new Topic [NUM_MAX_TOPIC];
	}
	
	public void inserisciTopic() {
		String testo = t.leggiStringa("Inserisci il titolo del topic:");
		TipologiaTopic tipologia = null;
		boolean topicValid = false;
		
		while(topicValid==false) {
			int tipo = t.leggiNumeroIntero("Inserisci la tipologia (1-cinema, 2-sport, 3-meteorologia:");
			switch (tipo) {
			case 1 : tipologia = TipologiaTopic.CINEMA;
					topicValid = true;
					break;
			case 2 : tipologia = TipologiaTopic.SPORT;
					topicValid = true;
					break;
			
			case 3 : tipologia = TipologiaTopic.METEOROLOGIA;
					topicValid = true;
						break;
			}
		}
		Topic to = new Topic (testo,tipologia);
		elencoTopic[index++] = to;
		
	}
	public void visualizzaTopics() {
			System.out.println("Ecco i topics:");
			for (int i=0; i<index; i++) {
			System.out.println(i+1+"-"+elencoTopic[i].getNome());
			}
	}
	
	public void inserisciCommento() {
		int i=0;
		int ris = 0;
		do {
			 ris = t.leggiNumeroIntero("Inserisci il numero del topic desiderato:");
		}while((ris<0)||(ris>index));
			
		String testo = t.leggiStringa("Inserisci un commento:");
		Commento c = new Commento(testo);
		elencoTopic[ris-1].aggiungiCommento(c);
		
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- Inserisci Topic");
		System.out.println("2- Visualizza Topics");
		System.out.println("3-Inserisci Commento");
		System.out.println("4- Uscita");
		
		return t.leggiNumeroIntero("Inserisci l'opzione:");
	}
	
	public static void main(String[] args) {
		Forum f = new Forum();
		int opz = 0;
		
		do {
			opz = f.menuUtente();
			switch(opz) {
			case 1 : f.inserisciTopic();
					break;
			case 2 : f.visualizzaTopics();
					break;
			case 3: f.inserisciCommento();
					break;
			case 4: System.out.println("Arrivederci!");
					break;
			}
		}while(opz!=4);

	}

}
