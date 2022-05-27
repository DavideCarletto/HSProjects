package liceocuneo.comune;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class GestioneDb {

	private ElencoComuni elencoComuni;

	Connection conn = null;
	String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	String user = "quintaf";
	String password = "iwish10";
	PreparedStatement stmt = null;


	public GestioneDb() {
		elencoComuni = new ElencoComuni();
	}

	public void leggiCsv() {
		File f = new File(
				"C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\Comune\\Elenco-comuni-italianiSimple.csv");
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		do {
			try {
				line = br.readLine();
				if (line != null) {
					String[] comuneS = line.split(",");

					String codice = comuneS[0];
					String denominazioneStraniera = comuneS[1];
					String denominazioneItaliana = comuneS[2];

					Comune comune = new Comune();
					comune.setCodice(codice);
					comune.setDenominazioneStraniera(denominazioneStraniera);
					comune.setDenominazioneItaliano(denominazioneItaliana);
					
					elencoComuni.add(comune);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (line != null);
	}

	public void provaConnessioneServer() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println(elencoComuni.size());
			conn = DriverManager.getConnection(url, user, password);
			for(int i=0; i<elencoComuni.size();i++) {
				stmt = conn.prepareStatement("INSERT INTO BCGT_ComuneItaliano (CodiceComune,NomeComuneItaliano,NomeComuneStraniero) VALUES (?,?,?)");
				stmt.setString(1,elencoComuni.get(i).getCodice());
				stmt.setString(2,elencoComuni.get(i).getDenominazioneItaliano());
				stmt.setString(3,elencoComuni.get(i).getDenominazioneStraniera());
				
				System.out.println(stmt.executeUpdate());
			}
		} catch (Exception e) {
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore
					
					stmt = null;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		GestioneDb g = new GestioneDb();
		g.leggiCsv();
		g.provaConnessioneServer();	}
}
