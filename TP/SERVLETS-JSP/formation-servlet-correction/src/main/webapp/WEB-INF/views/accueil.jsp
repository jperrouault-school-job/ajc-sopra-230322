<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/style.css" />
</head>
<body>
	<h1>Hello world!</h1>
	
	<c:if test="${ userSession != null }">
		<p>Bonjour ${ userRequest }</p>
		<p>Bonjour ${ userSession }</p>
	</c:if>
	
	<c:if test="${ userSession == null }">
		<p>Vous devez vous <a href="connexion">connecter</a>.</p>
	</c:if>
	
	
	<!-- Exemple commentaire HTML -->
	
	<%-- Commentaire JAVA --%>
	
</body>
</html>