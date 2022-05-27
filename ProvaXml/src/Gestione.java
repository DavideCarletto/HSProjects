import java.io.File;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Gestione")
public class Gestione {
	private static final String percorso = "C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\ProvaXml\\src\\file.xml";

	
	@XmlElementWrapper (name = "elencoArticoli")
	@XmlElement(name = "Articolo")
	
	private ElencoArticoli elencoArticoli;
	
	 public Gestione() {
		 elencoArticoli = new ElencoArticoli();
		 
		 Articolo articolo1 = new Articolo();
		 articolo1.setNome("articolo1");
		 articolo1.setPrezzo(12.5f);
		 articolo1.setDescrizione("no descrizione");
		 
		 Articolo articolo2 = new Articolo();
		 articolo2.setNome("articolo2");
		 articolo1.setPrezzo(12.5f);
		 articolo2.setDescrizione("no descrizione");
		 
		 elencoArticoli.aggiungiArticolo(articolo1);
		 elencoArticoli.aggiungiArticolo(articolo2);
	 }
	 
	public void daObjectaXml() {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Gestione.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Marshaller m = context.createMarshaller();
			m.marshal(Gestione.this, new File(percorso));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void daXmlaObject() {
		try {
			JAXBContext context = JAXBContext.newInstance(Gestione.class);
			Unmarshaller u = context.createUnmarshaller();
			
			Gestione g = (Gestione) u.unmarshal(new File(percorso));
			elencoArticoli = g.getElencoArticoli();
		for(int i=0; i<elencoArticoli.size(); i++) {
			System.out.println(elencoArticoli.get(i).toString());
		}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ElencoArticoli getElencoArticoli() {
		return elencoArticoli;
	}
	public static void main (String args[]) {
		Gestione g= new Gestione();
		g.daObjectaXml();
		g.daXmlaObject();
	}
}
