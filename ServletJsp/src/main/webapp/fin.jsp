<%@page import="es.salesianos.repository.Repository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.LinkedList"%>
<%@ page import = "es.salesianos.repository.*,es.salesianos.model.*"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
<b><%= request.getParameter("name") %></b>
<b><%= request.getParameter("course") %></b><br/>
<input type="button" value="Volver" onclick="self.location.href = 'datos.jsp'">
<form action="delete" method="post">
 <input value="Eliminar" type="submit">
 <input type="hidden" value="<%= request.getParameter("name") %>" name="name">
</form>
<table align="center">
	<tr><td>Idioma</td><td>Pais</td><td>Eliminar</td>
	</tr>
	<tr><td><%
		LinkedList<Idiomas> listaIdiomas = new Repository().getIdiomas();
		LinkedList<Paises> listaPaises = new Repository().getPaises();
		for (int i = 0; i < listaPaises.size(); i++) {
			out.println("<tr>");
			out.println("<td>" + listaIdiomas.get(i).getIdioma() + "</td>");
			out.println("<td>" + listaPaises.get(i).getPais() + "</td>");
			out.println("<td><a href=./delete?pais=" + listaPaises.get(i).getPais() + " >Eliminar</a></td>");
			out.println("</tr>");
		}
	%>
</table>

</body>
</html>