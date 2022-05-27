
<%@page import="liceocuneo.Libreria.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libreria</title>
</head>
<body>
	<% Libreria libreria = new Libreria();
	String check = request.getParameter("check");
	ElencoLibri elencoLibri = libreria.checkLibro(check);
	int i; 
	
	if(elencoLibri.size()>0){%>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Isbn</th>
      <th scope="col">Titolo1</th>
      <th scope="col">Titolo2</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <% for(i = 0 ; i< elencoLibri.size();i++){%>
      <th scope="row">1</th>
      <td><% out.println(String.valueOf(elencoLibri.get(i).getIsbn())); %></td>
      <td><%out.println(elencoLibri.get(i).getTitolo1()); %></td>
      <td><%out.println(elencoLibri.get(i).getTitolo2()); %></td>
    </tr>
  </tbody>
  <%}%>
</table>	
	<%}else{%>
		<h1>Libro non trovato</h1>
	<%}
	%>

</body>
</html>