import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

	public String getTesto() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		String testo="";
		try {
			testo = buf.readLine();
		} catch (IOException e) {					//prova ad intercettare una anomalia nel testo
			// TODO Auto-generated catch block
			e.printStackTrace();				
		}
		return testo;
		}
	public int getNumeroIntero() {
		String testo = getTesto();
		int num = Integer.parseInt(testo);
		return num;
	}
}
