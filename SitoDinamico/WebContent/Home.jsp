<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.*"%>
<%@ page import="liceocuneo.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%
	GestioneUtenti gestione = new GestioneUtenti();
	String email = request.getParameter("email");
	String psd = request.getParameter("psd");
	Utente u = gestione.validateLogin(email, psd);

	if (u != null) {
	%>
	<p>
		<%
		u.toString();
		%>
	</p>
	<%
	} else {
	%>
	<h1>Zoucl</h1>
	<%
	}
	%>


</body>
</html>