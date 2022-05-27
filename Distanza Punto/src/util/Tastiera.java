package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {
	
	public int LeggiNumeroIntero(String messaggio) {
		int ris = 0;
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		
		
		System.out.println(messaggio);
		try {
			
			String testo = buf.readLine();
				if (testo!=null)
				ris = Integer.parseInt(testo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	}
	
}
