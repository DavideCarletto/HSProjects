package liceocuneo.Ricettario;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Ricetta {

	private HashMap<Ingrediente, Float> elencoIngredienti;
	private String descrizione;
	private int tempoCottura;
	private String nome;

	public Ricetta(String nome,String descrizione, int tempoCottura) {
		super();
		this.descrizione = descrizione;
		this.tempoCottura = tempoCottura;
		this.nome = nome;
		elencoIngredienti = new HashMap<>();
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getTempoCottura() {
		return tempoCottura;
	}

	public void setTempoCottura(int tempoCottura) {
		this.tempoCottura = tempoCottura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<Ingrediente, Float> getElencoIngredienti() {
		return elencoIngredienti;
	}
	public void aggiungiIngrediente(Ingrediente ingrediente,Float valore) {
		elencoIngredienti.put(ingrediente,valore);
	}

	@Override
	public String toString() {
		return "Ricetta [descrizione=" + descrizione + ", tempoCottura=" + tempoCottura + ", nome=" + nome + "]";
	}

	public String[] toArrayString() {
		String[] ricettaS = new String[3];
		ricettaS[0] = nome;
		ricettaS[1] = descrizione;
		
		for(Entry<Ingrediente, Float> ingrediente : this.getElencoIngredienti().entrySet()) {
			ricettaS[2] += ingrediente.toString()+",";
		}
		return ricettaS;
	}
}
