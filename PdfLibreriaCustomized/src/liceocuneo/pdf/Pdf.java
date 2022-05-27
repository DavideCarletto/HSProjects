package liceocuneo.pdf;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	
	
	public static void generaPdf(String path, String content) {
		
		try {
			File file = new File(path);
			file.getParentFile().mkdirs();
			com.itextpdf.text.Document  document = (com.itextpdf.text.Document) new  com.itextpdf.text.Document ();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			document.add(new Paragraph(content));
			document.close();
			}catch(Exception e ) {
				e.printStackTrace();
		}
	}
	public static void apriPdf(String path) throws Exception{
		Process p = Runtime
					.getRuntime()
					.exec("rundll32 url.dll,FileProtocolHandler "+path);
		p.waitFor();
	}
}
