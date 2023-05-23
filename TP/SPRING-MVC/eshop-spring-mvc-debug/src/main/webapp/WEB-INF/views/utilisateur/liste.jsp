<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Liste des utilisateurs</h1>
		
		<a href="utilisateur/ajouter" class="btn btn-success">Créer</a>
		
		<c:if test="${ param.erreursup != null }">
			<div class="alert alert-danger">
				La suppression n'a pas fonctionné.
			</div>
		</c:if>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom d'utilisateur</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="utilisateur" items="${ utilisateurs }">
					<tr>
						<td>${ utilisateur.username }</td>
						<td>
							<a href="utilisateur/modifier/${ utilisateur.id }" class="btn btn-outline-warning">Modifier</a>
							<a href="utilisateur/supprimer/${ utilisateur.id }" class="btn btn-outline-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>