package liceocuneo.forum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

		public int leggiNumeroIntero(String messaggio) {
			int ris =0;
			String testo = null;
			System.out.println(messaggio);
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(is);
			try {
				testo = buf.readLine();
				if (testo != null)
					ris = Integer.parseInt(testo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ris;
		}
		public String leggiStringa(String messaggio) {
			String testo = null;
			System.out.println(messaggio);
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(is);
			try {
				testo = buf.readLine();		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return testo;
		}
}
