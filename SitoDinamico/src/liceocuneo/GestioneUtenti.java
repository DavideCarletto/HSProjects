package liceocuneo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneUtenti {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	private static final String userDb = "quintaf";
	private static final String password = "iwish10";
	
	public GestioneUtenti() {

	}
	public Utente validateLogin(String email, String psd) {
		java.sql.Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Utente utente = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userDb, password);

			stmt = conn.prepareStatement("SELECT * FROM CD_Utente WHERE Username=? AND Password=?");
			stmt.setString(1, email );
			stmt.setString(2, psd);
			
			

			result = stmt.executeQuery();

			while (result.next()) {
				String nome = result.getString("Nome");
				String cognome = result.getString("Cognome");
				
				utente = new Utente(nome, cognome, email, psd);
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return utente;
	}
}
