package liceocuneo.provaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaDB {

	Connection conn = null;
	String url = "jdbc:mysql://didattica.liceocuneo.it/db5F?serverTimezone=Europe/Rome";
	String user = "quintaf";
	String password = "iwish10";
	Statement stmt = null;
	ResultSet rs = null;

	public void provaConnessioneServer() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT lingua FROM DC_Film");
			
			while(rs.next())
			System.out.println(rs.getString("lingua"));

		} catch (Exception e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
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

	public static void main(String args[]) {
		ProvaDB prova = new ProvaDB();
		prova.provaConnessioneServer();

	}
}
