<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon panier</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Mon panier</h1>
		
		<a href="produit">Voir les produits</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prix</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="produit" items="${ panier }">
					<tr>
						<td>${ produit.nom }</td>
						<td>${ produit.prix } &euro;</td>
						<td>
							<a href="panier/supprimer/${ produit.id }" class="btn btn-outline-danger">Retirer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>