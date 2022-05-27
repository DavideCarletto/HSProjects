import java.util.ArrayList;

public class Studente {

	private int id;
	private String cognome;
	private String nome;
	private String badge;
	private int numeroVoti;
	private ArrayList<Voto> elencoVoti;
	public Studente() {
		elencoVoti = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public ArrayList<Voto> getElencoVoti() {
		return elencoVoti;
	}
	public void setElencoVoti(ArrayList<Voto> elencoVoti) {
		this.elencoVoti = elencoVoti;
	}
	
	public int getNumeroVoti() {
		return numeroVoti;
	}
	public void setNumeroVoti(int numeroVoti) {
		this.numeroVoti = numeroVoti;
	}
	@Override
	public String toString() {
		return "Studente [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", badge=" + badge + ", numeroVoti="
				+ numeroVoti + ", elencoVoti=" + elencoVoti + "]";
	}
	
	
	
}
