<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des fournisseurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Liste des fournisseurs</h1>
		
		<a href="fournisseur/ajouter" class="btn btn-success">Créer</a>
		
		<c:if test="${ param.erreursup != null }">
			<div class="alert alert-danger">
				La suppression n'a pas fonctionné.
			</div>
		</c:if>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Responsable</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="fournisseur" items="${ fournisseurs }">
					<tr>
						<td>${ fournisseur.nom }</td>
						<td>${ fournisseur.responsable }</td>
						<td>
							<a href="fournisseur/supprimer/${ fournisseur.id }" class="btn btn-outline-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>