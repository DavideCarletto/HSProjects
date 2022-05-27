package liceocuneo.provaXml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Gestione")
public class Gestione {
	
	@XmlElementWrapper(name = "ElencoProdotti")
	@XmlElement(name = "Prodotto")
	private ElencoProdotti elencoProdotti;
	public static final String percorso = "C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\XmlProva\\src\\elencoProdotti.xml";

	public Gestione() {
		elencoProdotti = new ElencoProdotti();

		Prodotto p1 = new Prodotto();
		p1.setNome("Prodotto1");
		p1.setDescrizione("prodotto bello");
		p1.setIban("746GD164");
		p1.setPrezzo(56.7f);
		Prodotto p2 = new Prodotto();
		p2.setNome("Prodotto2");
		p2.setDescrizione("prodotto");
		p2.setIban("73456FDSG4");
		p2.setPrezzo(5.18f);
		Prodotto p3 = new Prodotto();
		p3.setNome("Prodotto3");
		p3.setDescrizione("prodotto ancora menobello");
		p3.setIban("ASDFHJ454DGF");
		p3.setPrezzo(160.6f);

		elencoProdotti.aggiungiProdotto(p1);
		elencoProdotti.aggiungiProdotto(p2);
		elencoProdotti.aggiungiProdotto(p3);
	}

	public void creaXmlDaObject() {
		try {
			JAXBContext context = JAXBContext.newInstance(Gestione.class);
			Marshaller m = context.createMarshaller();
//			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(Gestione.this, new File(percorso));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void creaElencoDaXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Gestione.class);
			Unmarshaller m = context.createUnmarshaller();
			Gestione g = (Gestione) m.unmarshal(new File(percorso));
			elencoProdotti = g.getElencoProdotti();
			for (int i = 0; i < elencoProdotti.size(); i++) {
				System.out.println(elencoProdotti.get(i).toString());
			}

		} catch (
		JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public ElencoProdotti getElencoProdotti() {
		return elencoProdotti;
	}

	public static void main(String[] args) {
		Gestione g = new Gestione();
		g.creaXmlDaObject();
		g.creaElencoDaXml();
	}

}
