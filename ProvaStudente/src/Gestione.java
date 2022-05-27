import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Gestione {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it:3306/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";
	private ArrayList<Studente> elencoStudenti;

	public Gestione() {
		elencoStudenti = new ArrayList<>();
	}

	public void selezionaStudentiConVoti() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(
					"SELECT * FROM DOC_Studente, DOC_Voto WHERE DOC_Studente.Id = DOC_Voto.IdStudente");

			rs = stmt.executeQuery();

			Studente studCorr = null;

			while (rs.next()) {
				int idStud = rs.getInt("DOC_Studente.Id");
				if ((studCorr == null) || ((studCorr != null) && (studCorr.getId() != idStud))) {
					studCorr = new Studente();
					studCorr.setId(rs.getInt("Id"));
					studCorr.setCognome(rs.getString("Cognome"));
					studCorr.setNome(rs.getString("Nome"));
					studCorr.setBadge(rs.getString("Badge"));
					elencoStudenti.add(studCorr);
				}

				Voto v = new Voto();
				v.setId(rs.getInt("DOC_Voto.Id"));
				v.setValore(rs.getFloat("DOC_Voto.Valore"));
				v.setData(rs.getDate("DOC_Voto.Data"));
				v.setIdStudente(rs.getInt("DOC_Voto.IdStudente"));
				studCorr.getElencoVoti().add(v);
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

	public void visualizza() {
		for (int i = 0; i < elencoStudenti.size(); i++) {
			System.out.println(elencoStudenti.get(i).toString());
		}
	}

	public void conta() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement("SELECT  COUNT(*) FROM DOC_Studente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("COUNT(*)"));
			}
			

			while (rs.next()) {
				
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

	public static void main(String[] args) {
		Gestione g = new Gestione();
		g.selezionaStudentiConVoti();
		g.conta();
		g.visualizza();
	}
}
