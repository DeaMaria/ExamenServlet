<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.LinkedList"%>
<%@ page import = "es.salesianos.repository.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="welcome" method="post">
		<span>País:</span>
		<input type="text" name="pais"> <br/>
		
		<span>idioma:</span> 
		<select name="idioma">
		<%
		LinkedList<Idiomas> lista = new Repository().getIdiomas();
		for (int i = 0; i < lista.size(); i++) {
			out.println("<option value=" + lista.get(i).getIdioma()+">"+ lista.get(i).getIdioma() + "</option>");
			
		}
		%>
		</select>
		<br/>
		<input type="submit">
	</form>
	
	<form action="insert" method="post">
		<span>Idioma:</span>
		<input type="text" name="idioma"> <br/>
		<input type="submit" name="Insertar Idioma">
	</form>
	</body>
</html>