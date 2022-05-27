package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

	public int leggiNumeroIntero(String messaggio) { 
		int ris = 0;
		
		System.out.println(messaggio);
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader (is);
		String testo = null;
		
		try {
			 testo = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ris = Integer.parseInt(testo);
		return ris;
		
	}
}
