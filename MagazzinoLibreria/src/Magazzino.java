import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.text.Document;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Magazzino {

	private Libro[] elencoLibriMagazzino=null;
	private Cliente[] elencoClienti;
	private Scanner s  = new Scanner(System.in);
	private int index;
	private int index2;
	private float ricavoTotale;
	
	public Magazzino() {
		elencoLibriMagazzino = new Libro[1000];
		elencoClienti = new Cliente[1000];
		index =0;
		index2 =0;
		ricavoTotale = 0;
	}
	
	public float getRicavoTotale() {
		return ricavoTotale;
	}

	public void setRicavoTotale(float ricavoTotale) {
		this.ricavoTotale = ricavoTotale;
	}

	public Libro aggiungiLibro() {
		System.out.println("Inserisci i dati richiesti: ");
		System.out.println("Codice Isbn:");
		int codice = Integer.parseInt(s.nextLine());
		System.out.println("Titolo:");
		String titolo = s.nextLine();
		Genere genere = null;
		boolean value = true;
		
		do {
		
			try {
				System.out.println("Genere (1-STORICO, 2- FANTASCIENZA, 3- AVVENTURA, 4- HORROR, 5- AZIONE, 6- GIALLO, 7- THRILLER, 8- FIABA, 9- BIOGRAFIA,)");
				int scelta = Integer.parseInt(s.nextLine());
				
				switch(scelta) {
				
				case 1:
					genere = Genere.STORICO;
					break;
				case 2:
					genere = Genere.FANTASCIENZA;
					break;
				case 3:
					genere = Genere.AVVENTURA;
					break;
				case 4:
					genere = Genere.HORROR;
					break;
				case 5:
					genere = Genere.AZIONE;
					break;
				case 6:
					genere = Genere.GIALLO;
				break;
				case 7:
					genere = Genere.THRILLER;
					break;
				case 8:
					genere = Genere.FIABA;
					break;
				case 9:
					genere = Genere.BIOGRAFIA;
					break;
			
				}
					if (genere == null) {
						throw new Exception();
					}
					value = false;
			}catch(Exception exc) {
			System.out.println("input non valido. Riprovare");
			
			}
		}while(value == true);
		
		System.out.println("prezzo: ");
		float prezzo = Float.parseFloat(s.nextLine());
		
		Libro libro = new Libro (codice,titolo,genere,prezzo);
		
		System.out.println("Numero autori: ");
		int nAutori = Integer.parseInt(s.nextLine());
		
		for (int i=0; i<nAutori ; i++) {
			System.out.println("Dati del "+(i+1)+"° autore: ");
			System.out.println("Codice:");
			int codiceAutore = Integer.parseInt(s.nextLine());
			System.out.println("Nome:");
			String nome = s.nextLine();
			System.out.println("Cognome");
			String cognome = s.nextLine();
			System.out.println("Data di nascita (gg/mm/aaaa): ");
			String date = s.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			GregorianCalendar dataNascita = null;
			try {
				Date d = sdf.parse(date);
				dataNascita = new GregorianCalendar();
				dataNascita.setTime(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Autore autore = new Autore (codiceAutore,nome, cognome,dataNascita);	
			libro.addAutore(autore);
		}
		return libro;
	}

	public Cliente caricaDatiCliente() {
		System.out.println("Inserisci i dati richiesti ");
		System.out.println("Nome: ");
		String nome = s.nextLine();
		System.out.println("Cognome");
		String cognome = s.nextLine();
		System.out.println("Data di nascita: (gg/mm/aaaa)");
		String date = s.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar dataNascita = null;
		try {
			Date d = sdf.parse(date);
			dataNascita = new GregorianCalendar();
			dataNascita.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente cliente = new Cliente(nome,cognome,dataNascita);
		return cliente;
	}

	public void addLibro(Libro libro) {
		
		elencoLibriMagazzino[index++]=libro;
	}
	
	public void addCliente(Cliente cliente) {
		elencoClienti[index2++] = cliente;
	}
	
	public void generaTesseraPdf() {
		String path = "C:/FilePdf/MagazzinoLibreria/TesseraLibreria.pdf";
		try {
			File file = new File(path);
			file.getParentFile().mkdirs();
			com.itextpdf.text.Document  document = (com.itextpdf.text.Document) new  com.itextpdf.text.Document ();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			Image image = Image.getInstance("tesseraSconto.png");
			document.add(image);
			document.close();
			apriPdf(path);
			}catch(Exception e ) {
				e.printStackTrace();
		}
	}
	public void generaTabellaLibriPdf() {
		String path = "C:/FilePdf/MagazzinoLibreria/TabellaLibri.pdf";
		try {
			File file = new File(path);
			file.getParentFile().mkdirs();
			com.itextpdf.text.Document  document = (com.itextpdf.text.Document) new  com.itextpdf.text.Document ();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			document.add(new Paragraph("ELENCO LIBRI"));
			document.add(new Paragraph("\n"));
			PdfPTable table = new PdfPTable(4);
			PdfPCell cell = new PdfPCell (new Paragraph("Libri"));
			cell.setColspan(4);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(cell);
			table.addCell("Codice");
			table.addCell("Titolo");
			table.addCell("Genere");
			table.addCell("Prezzo In Euro");

			for(int i=0; i<index;i++) {
				if(elencoLibriMagazzino[i]!=null) {
				table.addCell(""+elencoLibriMagazzino[i].getCodice());
				table.addCell(""+elencoLibriMagazzino[i].getTitolo());
				table.addCell(""+elencoLibriMagazzino[i].getGenere());
				table.addCell(""+elencoLibriMagazzino[i].getPrezzo());
				}
			}
			
			document.add(table);
			document.close();
			apriPdf(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void visualizzaLibri() throws NoLibriMagazzinoException {

		boolean value = false;
	
			for (int i=0; i<index; i++) {
				if(elencoLibriMagazzino[i]==null) {
				System.out.println(""+(i+1)+"- libro venduto");
				}if(elencoLibriMagazzino[i]!=null) {
					System.out.println(""+(i+1)+": "+elencoLibriMagazzino[i].toString());
					value =true;
				}	
			}
			if(value == false) {
				throw new NoLibriMagazzinoException("non ci sono libri nel magazzino");
			}
		}
		
	
	
	public void vendidaLibro() {
		System.out.println("Scegliere il libro che si vuole vendere: ");
		int scelta = Integer.parseInt(s.nextLine());
		scelta = scelta-1;
	
		if(elencoLibriMagazzino[scelta]!=null) {
			System.out.println("Il cliente possiede la tessera? 1- SI 2- NO ");
			int opz = Integer.parseInt(s.nextLine());
			boolean value = true;
			if(opz == 1) {
				Cliente cliente =  caricaDatiCliente();
				for(int i=0; i< index2; i++) {
					if((elencoClienti[i].getNome().equals(cliente.getNome())==true)&&(((elencoClienti[i].getCognome().equals(cliente.getCognome()))==true))) {
						elencoLibriMagazzino[scelta].setPrezzo(elencoLibriMagazzino[scelta].getPrezzo()*0.80f);
						value = false;
						break;
					}
				}
				if(value == false) {
					System.out.println("Sconto applicato");
				}else {
					System.out.println("Spiacenti, non e' stato possibile trovare il cliente");
				}	
			}
			setRicavoTotale(getRicavoTotale()+elencoLibriMagazzino[scelta].getPrezzo());
			elencoLibriMagazzino[scelta]=null;
		}
	}
	
	public int menuUtente() {
		System.out.print("MENU UTENTE");
		System.out.println("\tRicavo totale vendite:"+getRicavoTotale());
		System.out.println("\n1- Aggiungi libro a magazzino");
		System.out.println("2- Carica dati cliente (per tessera sconto)");
		System.out.println("3- Visualizza l'elenco dei libri");
		System.out.println("4- Vendita libro");
		System.out.println("5- Uscita");
		return Integer.parseInt(s.nextLine());
		
	}
	public void apriPdf(String path) throws Exception{
		Process p = Runtime
					.getRuntime()
					.exec("rundll32 url.dll,FileProtocolHandler "+path);
		p.waitFor();
	}
	public static void main (String[]args) {
		Magazzino m = new Magazzino();
		Libro libro = null;
		Cliente cliente = null;
		int scelta = 0;
		do {
		 scelta = m.menuUtente();
			switch(scelta) {
			case 1: libro = m.aggiungiLibro();
					m.addLibro(libro);
					break;
			case 2: cliente = m.caricaDatiCliente();
					m.addCliente(cliente);
					m.generaTesseraPdf();
					break;
			case 3: try {
					m.visualizzaLibri();
					m.generaTabellaLibriPdf();
				} catch (NoLibriMagazzinoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
					break;
			case 4: try {
					m.visualizzaLibri();
					m.vendidaLibro();
					
				} catch (NoLibriMagazzinoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
					break;
			case 5: System.out.println("Arrivederci!");
					break;
			}
		}while(scelta!=5);
		
		
		
	}
	
	

}
