import javax.xml.bind.annotation.XmlType;
import javax.xml.ws.WebServiceProvider;

@XmlType(propOrder = {"nome","prezzo","descrizione"})
public class Articolo {

	private String nome;
	private float prezzo;
	private String descrizione;
	
	public Articolo(String nome, float prezzo, String descrizione) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}
	public Articolo() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	@Override
	public String toString() {
		return "Articolo [nome=" + nome + ", prezzo=" + prezzo + ", descrizione=" + descrizione + "]";
	}
	
	
}
