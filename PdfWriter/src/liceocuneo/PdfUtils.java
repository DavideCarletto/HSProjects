package liceocuneo;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PdfUtils {

	public static void generaPdf(String path, String content) throws Exception{
		File file = new File(path);
        file.getParentFile().mkdirs();
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        document.add(new Paragraph(content));
        document.close();
        
 
	}

	public static void apriPdf(String path) throws Exception{
		Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler "+path);
		p.waitFor();
	}

}
