package liceocuneo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneUtenti {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";
	
	public GestioneUtenti() {
		// TODO Auto-generated constructor stub
	}
	
	public Utente validateLogin(String utente, String psd) {
		Utente u = null;
		Connection conn =  null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,password);
			
			stmt = conn.prepareStatement("SELECT * FROM CD_Utente WHERE Username=? AND Password=?");
			stmt.setString(1, utente);
			stmt.setString(2, psd);
			
			res = stmt.executeQuery();
			
			if(res.next()) {
				String userUtente = res.getString("Username");
				String passwordUtente = res.getString("Password");
				String nome = res.getString("Nome");
				String cognome = res.getString("Cognome");
				int id = res.getInt("id");
				u = new Utente(id, nome, cognome, userUtente, passwordUtente);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
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
		
		return u;
	}
}
