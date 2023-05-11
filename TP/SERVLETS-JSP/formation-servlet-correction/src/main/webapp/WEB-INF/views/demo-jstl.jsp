<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Démo JSTL</title>
</head>
<body>
	<h1>Démo JSTL</h1>
	
	<table>
	  <c:forEach var="i" begin="0" end="7" step="1">
	    <tr>
	      <td>${ i }</td>
	      <td>${ i * i * i }</td>
	    </tr>
	  </c:forEach>
	</table>
	
</body>
</html>