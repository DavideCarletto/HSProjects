package esercizio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map.Entry;
import java.util.TreeMap;

public class UtenteServiceimpl implements UtenteService {

	@Override
	public TreeMap<Integer, Utente> caricaUtentiCsv(File f) {
		TreeMap<Integer,Utente> elencoUtenti = new TreeMap<>();
		
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		do {
			try {
				line = br.readLine();
				if(line!= null) {
				String[] utenteS = line.split(";");
				int codice = Integer.parseInt(utenteS[0]);
				String cognome = utenteS[1];
				String nome = utenteS[2];
				String dataS = utenteS[3];
				String username = utenteS[4];

				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

				GregorianCalendar dataRegistrazione = null;
				try {
					Date d = sdf.parse(dataS);
					dataRegistrazione = new GregorianCalendar();
					dataRegistrazione.setTime(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Utente utente = new Utente(nome, cognome, dataRegistrazione, username);
				elencoUtenti.put(codice, utente);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(line!=null);

	return elencoUtenti;

	}

	@Override
	public Utente cercaUtente(TreeMap<Integer, Utente> elencoUtenti, Integer codice) {
		return elencoUtenti.get(codice);
	}

	@Override
	public void visualizzaElencoUtenti(TreeMap<Integer, Utente> elencoUtenti) {
		ArrayList<Utente> elencoUtentiList = new ArrayList<>();
		
		for(Entry<Integer,Utente> utente: elencoUtenti.entrySet()) {
			if(utente!= null) {
				elencoUtentiList.add(utente.getValue());
			}
		}
		
		Collections.sort(elencoUtentiList,new Comparator<Utente>() {
			@Override
			public int compare(Utente o1, Utente o2) {
				String nome1 = o1.getNome();
				String nome2 = o2.getNome();
				
				return nome1.compareTo(nome2);
			}
		});
		
		for(int i=0; i<elencoUtentiList.size();i++) {
			System.out.println(elencoUtentiList.get(i).toString());
		}
	}

}
