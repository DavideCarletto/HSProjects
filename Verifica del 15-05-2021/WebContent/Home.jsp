<%@page import="java.io.File"%>
<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="liceocuneo.Verifica.GestioneGrafico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grafico</title>
</head>
<body>
	<%
	GestioneGrafico gestione = new GestioneGrafico();
	String stringa = request.getParameter("colonna");
	JFreeChart chart = gestione.getChart(stringa);
	if (chart != null) {
		ChartUtilities.saveChartAsPNG(new File("grafico.png"),
		chart, 100, 100);
	%><img alt="Grafico" src="grafico.png">
	<%
	}else{
		response.sendRedirect("index.html");
	}
	%>
</body>
</html>