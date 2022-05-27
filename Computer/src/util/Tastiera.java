package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {
		
		public int leggiNumeroIntero(messaggio) {
			int ris = 0;
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			
			System.out.println(messaggio);
			String testo = null;
			try {
				if (testo != null) {
				 testo = buf.readLine();
				 ris = Integer.parseInt(testo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ris;
		}
		
		public float leggiNumeroFloat(String messaggio) {
			float ris = 0;
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			
			System.out.println(messaggio);
			String testo = null;
			try {
				if (testo != null) {
				 testo = buf.readLine();
				 ris = Float.parseFloat(testo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ris;
		}
}
