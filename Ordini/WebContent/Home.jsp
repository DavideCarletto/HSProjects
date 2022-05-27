<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%@ page import="liceocuneo.backend.*"%>
	<%
	GestioneUtenti gestione = new GestioneUtenti();
	String utente = request.getParameter("utente");
	String psd = request.getParameter("password");
	Utente u = gestione.validateLogin(utente, psd);

	if (u != null) {
	%>
	<h1> Benvenuto,
		<%
		request.getSession().setAttribute("utente", u);
		out.println(""+u.getNome()+""+u.getCognome()+"!");
		%>
	</h1>
	<%
	} else {
	%>
	

	<%
	response.sendRedirect("index.html");
	/* RequestDispatcher rd = request.getRequestDispatcher("index.html");
	rd.forward(request, response);
	*/
	}
	%>
</body>
</html>