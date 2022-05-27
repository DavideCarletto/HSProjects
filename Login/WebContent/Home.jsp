<%@page import="sun.rmi.server.Dispatcher"%>
<%@page import="liceocuneo.Ordini.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<h1>Titolo</h1>
	<%
	String utente = request.getParameter("Utente");
	String Password = request.getParameter("Password");

	Utente u = new Utente(utente, Password);
	if (u != null) {
	%>
	<h1>
		<%
		out.println("Benvenuto" +u.getUtente() + "," + u.getPassword());
		%>
	</h1>
	<%
	} else {
		response.sendRedirect("index.html");
		
	}
	%>

</body>
</html>