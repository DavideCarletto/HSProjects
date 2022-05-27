import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


public class ElencoArticoli extends ArrayList<Articolo>{

	public void aggiungiArticolo(Articolo articolo) {
		this.add(articolo);
	}
}
