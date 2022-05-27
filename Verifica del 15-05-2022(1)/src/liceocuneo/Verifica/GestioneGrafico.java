package liceocuneo.Verifica;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class GestioneGrafico {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it:3306/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String psd = "iwish10";

	
	public JFreeChart getChart(String stringa) {
		Connection conn = null;
		JFreeChart chart = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, psd);

			String query = "select "+stringa+" from CD_InfoCovid;";
			JDBCCategoryDataset dataSet = new JDBCCategoryDataset(conn, query);
			chart = ChartFactory.createLineChart("Andamento_Contagi", "Data","Contagi",dataSet,PlotOrientation.VERTICAL,false,true,true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return chart;
	}
}
