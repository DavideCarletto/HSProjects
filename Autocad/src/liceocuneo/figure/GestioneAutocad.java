package liceocuneo.figure;

import java.io.File;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import liceocuneo.PdfUtils;

public class GestioneAutocad {

	public static final int NUM_MAX_FIGURE = 30;
	private static FiguraGeometrica elencoFigure[];
	Scanner s = new Scanner (System.in);
	
	public static int index = 0;
	public static final String DESTPDF = "pdf";
	
	public GestioneAutocad() {
		elencoFigure = new FiguraGeometrica[NUM_MAX_FIGURE];
	}
	
	public void inserisciPrimitiva() {
		
		String cod = null;
		String comando1 =null;
		int posizione1 =0;
		try {
			InserimentoException Ie = new InserimentoException("");
		System.out.println("Inserisci il codice: ");
		cod = s.next();
		posizione1 = cod.indexOf('(');
		comando1 = cod.substring(0, posizione1);
		Ie.inserisciPrimitiva(comando1);
		}catch( InserimentoException exc) {
			System.out.println(exc.getMessage());
		}
		
		Punto p = null;
		if (comando1.equals("RETTANGOLO")) {
			try {
			int posizione2 = cod.indexOf(';');
			String comando2 = cod.substring(posizione1+1,posizione2);
			int x1 = Integer.parseInt(comando2);
			int posizione3 = cod.indexOf ('-');
			String comando3 = cod.substring(posizione2+1,posizione3);
			int y1 = Integer.parseInt(comando3);
			int posizione4 = cod.indexOf(';',posizione3);
			String comando4 = cod.substring(posizione3+1,posizione4);		
			int b = Integer.parseInt(comando4);
			int posizione5 = cod.indexOf(')',posizione4);
			String comando5 = cod.substring(posizione4+1,posizione5);	
			int h = Integer.parseInt(comando5);
			
			 p = new Punto(x1,y1);
			FiguraGeometrica r = new Rettangolo (p,b,h);
			aggiungiFigura (r);
		}catch(StringIndexOutOfBoundsException exc) {
		    	  System.out.println("hai inserito i separatori in modo sbagliato!");
			}catch(NumberFormatException exc) {
					System.out.println("Non hai inserito tutti numeri oppure non ne hai inseriti abbastanza!");
			}catch(InputMismatchException exc) {
				System.out.println("errore");
			}catch (NullPointerException exc) {
				System.out.println("altro errore");
			}
		
		 if (comando1.equals("CERCHIO")) {
			int posizione2 = cod.indexOf(';');
			String comando2 = cod.substring(posizione1+1,posizione2);
			int x1 = Integer.parseInt(comando2);
			int posizione3 = cod.indexOf ('-');
			String comando3 = cod.substring(posizione2+1,posizione3);
			int y1 = Integer.parseInt(comando3);
			int posizione4 = cod.indexOf(')',posizione3);
			String comando4 = cod.substring(posizione3+1,posizione4);		
			int r = Integer.parseInt(comando4);
			p = new Punto(x1,y1);
			FiguraGeometrica c = new Cerchio (p,r);
			aggiungiFigura (c);
		}
	

		if(comando1.equals("LINEA")) {
			int posizione2 = cod.indexOf(';');
			String comando2 = cod.substring(posizione1+1, posizione2);
			int x1 = Integer.parseInt(comando2);
			int posizione3 = cod.indexOf ('-');
			String comando3 = cod.substring(posizione2+1,posizione3);
			int y1 = Integer.parseInt(comando3);
			int posizione4 = cod.indexOf(';',posizione3);
			String comando4 = cod.substring(posizione3+1,posizione4);		
			int x2 = Integer.parseInt(comando4);
			int posizione5 = cod.indexOf(')',posizione4);
			String comando5 = cod.substring(posizione4+1,posizione5);	
			int y2 = Integer.parseInt(comando5);
			
			p = new Punto (x1,y1);
			Punto p2 = new Punto (x2,y2);
			FiguraGeometrica l = new Linea (p,p2);
			
			aggiungiFigura (l);
			}
			}
		}

	
	public void aggiungiFigura(FiguraGeometrica f) {
		elencoFigure[index++] = f;
	}
	
	public void visualizzaPrimitive() {
		for (int i=0; i<index;i++) {
			System.out.println(elencoFigure[i].toString());
		}
	}
	public float calcolaAreaTot() {
		float areaTot =0;
		for (int i=0; i<index; i++) {
			if(elencoFigure[i] instanceof FiguraChiusa) {
			
			areaTot += ((FiguraChiusa) elencoFigure[i]).calcolaArea();
			}
			
		}
		return areaTot;
	}
	public int menuUtente() {
		System.out.println("MENU UTENTE");
		System.out.println("1- Inserisci primitiva");
		System.out.println("2- Visualizza primitive");
		System.out.println("3- Calcola area totoale");
		System.out.println("4- Uscita");
		System.out.println("Scegli: ");
		return s.nextInt();
		
	}
	public static void generaPdf() throws Exception{
		String path= "C:\\Java\\Pdf";
		File file = new File(path);
        file.getParentFile().mkdirs();
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        for(int i =0; i<index; i++) {
        document.add(new Paragraph(elencoFigure[i].toString()));
        }
        document.close();
        apriPdf(path);
	}

	public static void apriPdf(String path) throws Exception{
		Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler "+path);
		p.waitFor();
	}
	public static void main (String[]args) {
		GestioneAutocad gAut = new GestioneAutocad();
		int opz = 0;
		
		do {
			opz = gAut.menuUtente();
			switch(opz) {
			case 1: gAut.inserisciPrimitiva();
				break;
			case 2: gAut.visualizzaPrimitive();
				break;
			case 3:
				System.out.println("l'area totale e': "+gAut.calcolaAreaTot());
				break;
			case 4:
				System.out.println("Arrivederci!");
				break;
			}
			
		}while (opz != 4);
		try {
			gAut.generaPdf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
