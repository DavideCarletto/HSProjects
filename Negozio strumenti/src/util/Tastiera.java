package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

		public String leggiNumero(String messaggio) {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			
			String testo = null;
			System.out.println(messaggio);
			
			try {
				testo = buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return testo;
		}
		
		public int leggiNumeroIntero(String messaggio) {
			int ris = 0;
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			
			String testo = null;
			System.out.println(messaggio);
			
			try {
				testo = buf.readLine();
				if (testo!= null) {
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
			
			String testo = null;
			System.out.println(messaggio);
			
			try {
				testo = buf.readLine();
				if (testo!= null) {
					ris = Float.parseFloat(testo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ris;
		}
}
