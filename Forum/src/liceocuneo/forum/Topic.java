package liceocuneo.forum;

public class Topic {
	private static final int NUM_MAX_COMMENTI = 1000;
	private String nome;
	private TipologiaTopic tipologia;
	private Commento[] elencoCommenti;
	private int index = 0;
	
	public Topic(String nome, TipologiaTopic tipologia) {
		this(nome);
		this.tipologia = tipologia;
	}
	public Topic (String nome) {
		this.nome = nome;
		elencoCommenti = new Commento[NUM_MAX_COMMENTI];
	}
	
	public String getNome() {
		return nome;
	}
	public TipologiaTopic getTipologia() {
		return tipologia;
	}
	
	public Commento[] getElencoCommenti() {
		return elencoCommenti;
	}
	public void aggiungiCommento(Commento c) {
		elencoCommenti[index++] = c;
	}

}
