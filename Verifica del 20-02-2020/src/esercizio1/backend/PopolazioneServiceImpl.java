package esercizio1.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopolazioneServiceImpl implements PopolazioneService {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";

	@Override
	public ElencoInformazioni leggiDati(File f) {
		FileReader reader = null;
		BufferedReader buf = null;
		ElencoInformazioni elenco = new ElencoInformazioni();
		try {
			reader = new FileReader(f);
			buf = new BufferedReader(reader);
			String line = buf.readLine();

			do {
				if (line != null) {
					String[] infoS = line.split(";");
					String stato = infoS[0];
					int popolazione = Integer.parseInt(infoS[1]);
					String anno = infoS[2];

					Informazione info = new Informazione(stato, popolazione, anno);
					elenco.add(info);
				}
			} while (line != null);
		} catch (Exception e) {

		}
		return elenco;
	}

	@Override
	public void caricaSuDb(ElencoInformazioni elenco) {

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.prepareStatement("INSERT INTO CD_InformazionePopolazione VALUES (?,?,?)");
			
			for(int i=0; i< elenco.size();i++) {
				stmt.setString(1, elenco.get(i).getStato());
				stmt.setInt(2, elenco.get(i).getPopolazione());
				stmt.setString(3, elenco.get(i).getAnno());
				
				stmt.executeUpdate();
			}
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public ElencoInformazioni leggiDatiOrdinati(boolean decrescente) {
		ElencoInformazioni elenco = new ElencoInformazioni();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,password);
			
			if(decrescente) {
				stmt = conn.prepareStatement("SELECT Stato FROM CD_InformazionePopolazione ORDER BY Popolazione(DESC)");
			}else {
				stmt = conn.prepareStatement("SELECT Stato FROM CD_InformazionePopolazione ORDER BY Popolazione");
			}
			
			result = stmt.executeQuery();
			
			while(result.next()) {
				String stato = result.getString("Stato");
				int popolazione = result.getInt("Popolazione");
				String anno = result.getString("Anno");
				Informazione info = new Informazione(stato, popolazione, anno);
				elenco.add(info);
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return elenco;
	}

}
