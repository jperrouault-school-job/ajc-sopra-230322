<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Produit</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prix</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="produit" items="${ produits }">
				<tr>
					<td>${ produit.getId() }</td>
					<td>${ produit.nom }</td>
					<td>${ produit.prix } euros</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>