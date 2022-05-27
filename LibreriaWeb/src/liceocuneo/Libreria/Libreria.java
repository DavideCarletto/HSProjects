package liceocuneo.Libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Libreria {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";
	private ElencoLibri elencoLibri;
	
	public Libreria() {
		elencoLibri = new ElencoLibri();
	}
	public ElencoLibri checkLibro(String check) {
		Libro libro = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement(
					" SELECT * FROM  DOC_Libro WHERE Isbn LIKE ? OR Titolo1 LIKE ? OR Titolo2 LIKE ?");

			
			stmt.setString(1, "%"+check+"%");
			stmt.setString(2,"%"+check+"%");
			stmt.setString(3, "%"+check+"%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				String isbnS = rs.getString("Isbn");
				String titolo1S = rs.getString("Titolo1");
				String titolo2S = rs.getString("Titolo2");

				libro = new Libro(isbnS, titolo1S, titolo2S);
				elencoLibri.add(libro);
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
		return elencoLibri;
	}
	public ElencoLibri getElencoLibri() {
		return elencoLibri;
	}
	
	
}
