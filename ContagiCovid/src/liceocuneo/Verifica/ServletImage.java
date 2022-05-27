package liceocuneo.Verifica;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import liceocuneo.Verifica.GestioneGrafico;

/**
 * Servlet implementation class ServletImage
 */
@WebServlet("/ServletImage")
public class ServletImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestioneGrafico  gestione = new GestioneGrafico();
		String stringa = request.getParameter("colonna");
		JFreeChart chart = gestione.getChart(stringa);
		
		response.setContentType("image/png");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ChartUtilities.writeChartAsPNG(out, chart, 1980, 1020);
		byte[] bytes = out.toByteArray();
		response.getOutputStream().write(bytes);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
