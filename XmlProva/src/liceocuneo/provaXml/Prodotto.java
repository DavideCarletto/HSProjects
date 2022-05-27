package liceocuneo.provaXml;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nome", "descrizione", "iban", "prezzo" })
public class Prodotto {

	private String nome;
	private String descrizione;
	private String iban;
	private float prezzo;


	public Prodotto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", descrizione=" + descrizione + ", iban=" + iban + ", prezzo=" + prezzo
				+ "]";
	}

}
