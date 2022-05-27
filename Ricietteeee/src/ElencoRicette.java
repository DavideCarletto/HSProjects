import java.util.ArrayList;
import java.util.HashMap;

public class ElencoRicette extends HashMap<Ingrediente, ArrayList<Ricetta>> {

	public void aggiungiRicetta(Ricetta r) {
		for(Entry<Ingrediente, Float> ingrediente: r.getElencoIngredienti().entrySet()) {
			if(!this.containsKey(ingrediente.getKey())) {
				put(ingrediente.getKey(), new ArrayList<Ricetta>());
			}
			get(ingrediente.getKey()).add(r);
		}
	}
	
	public ArrayList<Ricetta> ricercaRicette(Ingrediente ingrediente){
		return get(ingrediente);
	}
	
}
